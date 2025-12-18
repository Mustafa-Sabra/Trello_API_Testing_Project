package com.automation.api;

import com.automation.base.BaseTest;
import com.automation.pojo.Board;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BoardAPI extends BaseTest {

    @Step("Create a new Board")
    public Response createBoard(Board board)
    {
        return given()
                .queryParams("key",Apikey, "token",Apitoken,"name", board.getName())
                .spec(ReqSpecs)
                .log().all()
                .when()
                .post("/boards")
                .then()
                .log().all()
                .extract()
                .response();


    }

    @Step("Get board by ID")
    public Response getBoard(String id, HashMap<String,String> queryParams)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey , "token",Apitoken)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get("/boards/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Delete board by ID")
    public Response deleteBoard(String id)
    {
        return given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey, "token", Apitoken)
                .when()
                .delete("/boards/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    @Step ("Update Board")
    public Response updateBoard(String id, HashMap <String, String> fields)
    {
        return  given()
                .spec(ReqSpecs)
                .queryParams("key",Apikey,"token", Apitoken)
                .queryParams(fields)
                .when()
                .put("/boards/" + id)
                .then()
                .log().all()
                .extract().response();

    }


}
