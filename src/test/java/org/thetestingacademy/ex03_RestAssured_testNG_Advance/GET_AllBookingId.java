package org.thetestingacademy.ex03_RestAssured_testNG_Advance;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class GET_AllBookingId {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void getAllBookingId()
    {
        POST_CreateToken.createToken();
        r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .header("Authorization","token",POST_CreateToken.getToken());
        response = r.when().log().all().get();
        vr = response.then().log().all();

        vr.statusCode(200);

        List<Integer> bookingIDList = response.jsonPath().getList("bookingid");

       System.out.println(bookingIDList);

        if(bookingIDList.contains(1180))
            System.out.println("Booking ID "+1180+" found");
        else
            System.out.println("Booking ID "+1180+" not found");

    }

}
