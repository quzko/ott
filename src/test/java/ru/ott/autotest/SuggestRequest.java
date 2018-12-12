package ru.ott.autotest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SuggestRequest {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.onetwotrip.com/_hotels/api/suggestRequest";
    }

    @Test(description = "Проверка положительного ответа", priority = 1)
    public void responseTest() {
        given()
                .queryParam("query", "Мос")
                .queryParam("lang", "ru")
                .queryParam("locale", "ru")
                .queryParam("currency", "RUB").
                when()
                .get()
                .then().statusCode(200);
    }

    @Test(description = "Проверка наличия не пустых полей в ответе", priority = 2)
    public void restResultTest() {
        given()
                .queryParam("query", "Мос")
                .queryParam("lang", "ru")
                .queryParam("locale", "ru")
                .queryParam("currency", "RUB").
                when()
                .get()
                .then()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }

}



