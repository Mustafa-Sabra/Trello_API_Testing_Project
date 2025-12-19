package com.automation.api.lists;

import java.util.HashMap;
import java.util.Map;

public class CreateListParams {

    private final HashMap<String,Object> params = new HashMap<>();

    public CreateListParams(String listName, String idBoard)
    {
        params.put("name", listName);
        params.put("idBoard", idBoard);

    }

    public CreateListParams idListSource(String idListSource)
    {
        params.put("idListSource", idListSource);

        return  this;
    }

    public CreateListParams pos(String pos)
    {
        params.put("pos", pos);

        return  this;
    }

    public CreateListParams pos(float pos)
    {
        params.put("pos", pos);

        return  this;
    }

    public Map<String, Object> build()
    {
        return params;
    }



}
