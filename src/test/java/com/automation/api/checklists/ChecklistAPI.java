package com.automation.api.checklists;

import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ChecklistAPI  {

    @Step("Create a new Checklist")
    public Response createChecklist(CreateCheckListParams queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());

        return RestClient.post("/checklists", params, ResponseSpecs.created());
    }

    @Step("Get a Checklist by ID")
    public Response getChecklist(String id, HashMap<String,String> queryParams)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.get("/checklists/" + id, params, ResponseSpecs.success());
    }

    @Step("Delete a Checklist by ID")
    public Response deleteChecklist(String id )
    {
        return RestClient.delete("/checklists/" + id, AuthUtils.authUtils(), ResponseSpecs.success());
    }

    @Step("Update a Checklist by ID")
    public Response updateChecklist(String id, HashMap<String,Object> queryParams )
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.delete("/checklists/" + id, params, ResponseSpecs.success());
    }


}
