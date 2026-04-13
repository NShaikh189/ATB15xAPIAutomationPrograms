package org.thetestingacademy.org.thetestingacademy.ex_03_RestAssured_TestNg_Advance;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class POST_CreateBooking extends POST_NonBDDStyle{
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;

    //@Test(dependsOnMethods = "createToken")
    @Test
    public void createBookingTest()
    {
        POST_NonBDDStyle.createToken();
        System.out.println(POST_NonBDDStyle.getToken());

    }
}
