package com.automation.api.boards;

import java.util.HashMap;

public class CreateBoardParams {

    private final HashMap<String,String> params = new HashMap<>();

    public CreateBoardParams(String name)
    {

        params.put("name", name);
    }

    public CreateBoardParams idOrganizaion(String idOrganization)
    {
        params.put("idOrganization", idOrganization);
        return this;
    }

    public HashMap<String,String> build()
    {

        return params;
    }


}
