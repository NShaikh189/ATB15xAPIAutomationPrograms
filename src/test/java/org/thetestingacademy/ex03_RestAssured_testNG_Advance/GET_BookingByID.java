package org.thetestingacademy.ex03_RestAssured_testNG_Advance;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_BookingByID extends POST_CreateBooking{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test(dependsOnMethods = "createBookingTest")
    public void getBookingById()
    {
        System.out.println("GET.."+POST_CreateBooking.bookingId);
        r =    RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/")
                .pathParam("id",POST_CreateBooking.bookingId)
                //.param("id",POST_CreateBooking.bookingId)
                .header("Authorization","token",POST_CreateToken.getToken());
        response = r.log().all().get("/{id}");
        vr = response.then().log().all();
        vr.statusCode(200);

       String firstname = response.jsonPath().getString("firstname");
        System.out.println(firstname);
    }
}
