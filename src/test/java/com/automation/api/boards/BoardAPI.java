package com.automation.api.boards;

import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BoardAPI  {

    @Step("Create a new Board")
    public Response createBoard(CreateBoardParams queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());


        return RestClient.post("/boards", params, ResponseSpecs.created());

    }

    @Step("Get board by ID")
    public Response getBoard(String idBoard, HashMap<String,Object> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.get("/boards/" + idBoard, params, ResponseSpecs.success());
    }

    @Step("Delete board by ID")
    public Response deleteBoard(String idBoard)
    {
        return RestClient.delete("/boards/" + idBoard, AuthUtils.authUtils(), ResponseSpecs.success());
    }

    @Step ("Update Board")
    public Response updateBoard(String idBoard, HashMap <String, Object> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return  RestClient.update("/boards/" + idBoard, params, ResponseSpecs.success());

    }


}
