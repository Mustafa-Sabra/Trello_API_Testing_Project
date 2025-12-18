package com.automation.api;

import com.automation.base.BaseTest;
import com.automation.pojo.Board;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CardAPI extends BaseTest {

    @Step("Create a new Card")
    public Response createCard(String idList, HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token",Apitoken,"idList", idList)
                .queryParams(queryParams)
                .log().all()
                .when()
                .post("/cards")
                .then()
                .log().all()
                .extract()
                .response();


    }

    @Step("Get card by ID")
    public Response getCard(String id, HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey , "token",Apitoken)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get("/cards/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Delete card by ID")
    public Response deleteCard(String id)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token", Apitoken)
                .when()
                .delete("/cards/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    @Step ("Update card")
    public Response updateCard(String id, HashMap<String, String> queryParams)
    {
        return  given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey,"token", Apitoken)
                .queryParams(queryParams)
                .when()
                .put("/cards/" + id)
                .then()
                .log().all()
                .extract().response();

    }
}
