package com.automation.api;

import com.automation.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ChecklistAPI extends BaseTest {

    @Step("Create a new Checklist")
    public Response createChecklist(String idCard, HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token",Apitoken,"idCard", idCard)
                .queryParams(queryParams)
                .log().all()
                .when()
                .post("/checklists")
                .then()
                .log().all()
                .extract()
                .response();


    }

    @Step("Get Checklist by ID")
    public Response getChecklist(String id , HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey , "token",Apitoken)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get("/checklists/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Delete Checklist by ID")
    public Response deleteChecklist(String id)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token", Apitoken)
                .when()
                .delete("/checklists/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    @Step ("Update Checklist")
    public Response updateChecklist(String id, HashMap<String, String> queryParams)
    {
        return  given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey,"token", Apitoken)
                .queryParams(queryParams)
                .when()
                .put("/checklists/" + id)
                .then()
                .log().all()
                .extract().response();

    }

}
