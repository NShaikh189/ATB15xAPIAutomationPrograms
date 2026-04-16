package org.thetestingacademy.ex03_RestAssured_testNG_Advance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class POST_CreateBooking {
    private static RequestSpecification r;
    private static Response response;
    private static ValidatableResponse vr;
    static String token;
    static String bookingId;
    //@Test(dependsOnMethods = "createToken")
    @Test
    public  void createBookingTest()
    {
        String payload = "{\n" +
                "  \"firstname\": \"Jim\",\n" +
                "  \"lastname\": \"Brown\",\n" +
                "  \"totalprice\": 111,\n" +
                "  \"depositpaid\": true,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"2018-01-01\",\n" +
                "    \"checkout\": \"2019-01-01\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        //POST_CreateToken.createToken();
        token= POST_CreateToken.getToken();
        System.out.println(POST_CreateToken.getToken());

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
//                .contentType("application/json")
                .contentType(ContentType.JSON)
                .header("Authentication","token",token)
                .body(payload);
        response = r.when().log().all().post();
        vr = response.then().log().all();
        vr.statusCode(200);


        bookingId = response.jsonPath().getString("bookingid");
        int bid = Integer.parseInt(bookingId);
        String firstName = response.jsonPath().getString("booking.firstname");
        String checkinDate = response.jsonPath().getString("booking.bookingdates.checkin");
        System.out.println(bid);
        System.out.println(firstName);
        System.out.println(checkinDate);
    }
}
