package com.automation.api.lists;


import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

public class ListAPI   {

    @Step("Create a new List")
    public Response createList(CreateListParams queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());


        return RestClient.post("/lists", params, ResponseSpecs.created());

    }

    @Step("Get List by ID")
    public Response getList(String id, HashMap<String,String> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.post("/lists/" + id, params, ResponseSpecs.created());

    }

    @Step("Archive/Unarchive a List by ID")
    public Response archiveOrUnarchiveList(String id, HashMap<String,Boolean> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.post("/lists/" + id, params, ResponseSpecs.created());

    }

    @Step("update List by ID")
    public Response updateList(String id, HashMap<String,Object> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);


        return RestClient.post("/lists/" + id, params, ResponseSpecs.created());

    }

}
