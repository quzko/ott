package ru.ott.redirect;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class RedirectTestApi {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://onetwotrip.com";
    }

    @Test
    public void doesntFollowRedirects() {
        given().
                redirects().follow(false).
                expect().
                statusCode(301).
                header("Location", is("https://www.onetwotrip.com/redirect")).
                when().
                get("/redirect");
    }
}