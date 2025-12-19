package com.automation.api.checklists;

import java.util.HashMap;

public class CreateCheckListParams {

    private final HashMap<String,Object> params = new HashMap<>();


    CreateCheckListParams(String idCard)
    {
        params.put("idCard", idCard);
    }

    public CreateCheckListParams name(String name)
    {
        params.put("name", name);
        return this;
    }

    public CreateCheckListParams pos(String pos)
    {
        params.put("pos", pos);
        return this;
    }

    public CreateCheckListParams pos(float pos)
    {
        params.put("pos", pos);
        return this;
    }

    public CreateCheckListParams idChecklistSource(String idChecklistSource)
    {
        params.put("idChecklistSource", idChecklistSource);
        return this;
    }

    public HashMap<String,Object> build(){


        return params;

    }


}
