package org.thetestingacademy.ex03_RestAssured_testNG_Advance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;

import static org.hamcrest.Matchers.emptyString;

public class POST_CreateToken {

    private static RequestSpecification r;
    private static Response response;
    private static ValidatableResponse vr;
    static String token;

    public static String getToken()
    {
        return token;
    }

    @BeforeTest
    public static void createToken()
    {
        String payload = "{\n" +
                "  \"username\": \"admin\",\n" +
                "  \"password\": \"password123\"\n" +
                "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();
        response =  r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("token", Matchers.not(emptyString()));
        token = response.jsonPath().getString("token");
        System.out.println(token);

    }
}
