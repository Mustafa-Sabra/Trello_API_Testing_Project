package com.automation.api.cards;

import com.automation.api.boards.CreateBoardParams;
import com.automation.api.lists.CreateListParams;
import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CardAPI {

    @Step("Create a new Card")
    public Response createCard(CreateCardParams queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());


        return RestClient.post("/cards", params, responseSpecs);

    }

    @Step("Get Card by ID")
    public Response getCard(String id, HashMap<String,Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.get("/cards/" + id, params, responseSpecs);

    }

    @Step("delete card by ID")
    public Response deleteCard(String id, ResponseSpecification responseSpecs)
    {
        return RestClient.delete("/cards/" + id,  AuthUtils.authUtils(), responseSpecs);

    }

    @Step("update Card by ID")
    public Response updateList(String id, HashMap<String,Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.update("/cards/" + id, params, responseSpecs);

    }



}
