package ru.ott.autotest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ott.autotest.model.ParametersList;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SuggestRequest {
    private static String param = "&lang=ru&locale=ru&currency=RUB";
    private static ParametersList list = new ParametersList();

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.onetwotrip.com/_hotels/api/suggestRequest";
    }

    @Test(description = "Проверка положительного ответа", priority = 1)
    public void responseTest() {
        given()
                .queryParam("query", list.getName())
                .queryParam(param).
                when()
                .get()
                .then().statusCode(200);
    }

    @Test(description = "Проверка наличия не пустых полей в ответе", priority = 2)
    public void restResultTest() {
        given()
                .queryParam("query", list.getName())
                .queryParam(param).
                when()
                .get()
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}



