package com.automation.api;

import com.automation.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ListAPI extends BaseTest {

    @Step("Create a new List")
    public Response createList(String name, String idBoard, HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token",Apitoken,"name", name, "idBoard", idBoard)
                .queryParams(queryParams)
                .log().all()
                .when()
                .post("/lists")
                .then()
                .log().all()
                .extract()
                .response();


    }

    @Step("Get List by ID")
    public Response getList(String id , HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey , "token",Apitoken)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get("/lists/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Archive List by ID")
    public Response archiveList(String id)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token", Apitoken, "value", true)
                .when()
                .put("/lists/" + id + "/closed")
                .then()
                .log().all()
                .extract().response();
    }

    @Step("Unarchive List by ID")
    public Response unarchiveList(String id)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token", Apitoken, "value", false)
                .when()
                .put("/lists/" + id + "/closed")
                .then()
                .log().all()
                .extract().response();
    }

    @Step ("Update List")
    public Response updateList(String id, HashMap<String, String> queryParams)
    {
        return  given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey,"token", Apitoken)
                .queryParams(queryParams)
                .when()
                .put("/lists/" + id)
                .then()
                .log().all()
                .extract().response();

    }


}
