package com.automation.api;

import com.automation.base.BaseTest;
import com.automation.client.RestClient;
import com.automation.pojo.Board;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BoardAPI  {

    @Step("Create a new Board")
    public Response createBoard(String boardName)
    {
        HashMap<String,String> params = AuthUtils.authUtils();
        params.put("name", boardName);


        return RestClient.post("/boards", params);

    }

    @Step("Get board by ID")
    public Response getBoard(String id, HashMap<String,String> queryParams)
    {
        return RestClient.get("boards" + id, AuthUtils.authUtils());
    }

    @Step("Delete board by ID")
    public Response deleteBoard(String id)
    {
        return RestClient.delete("/boards" + id, AuthUtils.authUtils());
    }

    @Step ("Update Board")
    public Response updateBoard(String id, HashMap <String, String> fields)
    {
        return  null;

    }


}
