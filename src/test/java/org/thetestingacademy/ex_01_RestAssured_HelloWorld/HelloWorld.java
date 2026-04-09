package org.thetestingacademy.ex_01_RestAssured_HelloWorld;

import io.restassured.RestAssured;

import org.testng.annotations.Test;


public class HelloWorld {

    @Test
    public void testHelloWorld(){
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/ping")
                .when()
                    .get()
                .then()
                .statusCode(200);
    }
}
