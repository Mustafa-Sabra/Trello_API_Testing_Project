package com.automation.api.checklists;

import com.automation.client.ResponseSpecs;
import com.automation.client.RestClient;
import com.automation.utils.AuthUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class ChecklistAPI  {

    @Step("Create a new Checklist")
    public Response createChecklist(CreateCheckListParams queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams.build());

        return RestClient.post("/checklists", params, responseSpecs);
    }

    @Step("Get a Checklist by ID")
    public Response getChecklist(String id, HashMap<String,String> queryParams, ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.get("/checklists/" + id, params, responseSpecs);
    }

    @Step("Delete a Checklist by ID")
    public Response deleteChecklist(String id, ResponseSpecification responseSpecs )
    {
        return RestClient.delete("/checklists/" + id, AuthUtils.authUtils(), responseSpecs);
    }

    @Step("Update a Checklist by ID")
    public Response updateChecklist(String id, HashMap<String,Object> queryParams , ResponseSpecification responseSpecs)
    {
        HashMap<String,Object> params = AuthUtils.authUtils();
        params.putAll(queryParams);

        return RestClient.update("/checklists/" + id, params, responseSpecs);
    }


}
