package com.automation.api.boards;

import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BoardAPI  {

    @Step("Create a new Board")
    public Response createBoard(CreateBoardParams queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());

        return RestClient.post("/boards", params, responseSpecs);

    }

    @Step("Get board by ID")
    public Response getBoard(String idBoard, HashMap<String,Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.get("/boards/" + idBoard, params, responseSpecs);
    }

    @Step("Delete board by ID")
    public Response deleteBoard(String idBoard, ResponseSpecification responseSpecs)
    {
        return RestClient.delete("/boards/" + idBoard, AuthUtils.authUtils(), responseSpecs);
    }

    @Step ("Update Board")
    public Response updateBoard(String idBoard, HashMap <String, Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return  RestClient.update("/boards/" + idBoard, params, responseSpecs);

    }


}
