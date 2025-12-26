package com.automation.api.lists;


import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class ListAPI   {

    @Step("Create a new List")
    public Response createList(CreateListParams queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());


        return RestClient.post("/lists/", params, responseSpecs);

    }

    @Step("Get List by ID")
    public Response getList(String id, HashMap<String,String> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.get("/lists/" + id, params, responseSpecs);

    }

    @Step("Archive/Unarchive a List by ID")
    public Response archiveOrUnarchiveList(String id, HashMap<String,Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.update("/lists/" + id + "/closed", params, responseSpecs);

    }

    @Step("update List by ID")
    public Response updateList(String id, HashMap<String,Object> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.update("/lists/" + id, params, responseSpecs);

    }

}
