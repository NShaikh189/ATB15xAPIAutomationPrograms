package org.thetestingacademy.ex_02_RestAssured_basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Multiple_Testcase {

    @Test
    public void test_Positive_tc1()
    {
        String pincode = "411017";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }


    @Test
    public void test_Negative_tc1()
    {
        String pincode = "411017222";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(404);
    }
}
