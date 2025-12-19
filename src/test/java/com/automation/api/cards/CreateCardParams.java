package com.automation.api.cards;

import com.automation.api.boards.CreateBoardParams;

import java.util.HashMap;

public class CreateCardParams {

    private final HashMap<String,Object> params = new HashMap<>();


    public CreateCardParams(String idList)
    {
        params.put("idList", idList);
    }

    public CreateCardParams name(String cardName)
    {
        params.put("name",cardName);
        return this;
    }

    public CreateCardParams desc(String desc)
    {
        params.put("desc",desc);
        return this;
    }

    public CreateCardParams start(String start)
    {
        params.put("start",start);
        return this;
    }

    public CreateCardParams dueComplete(String dueComplete)
    {
        params.put("dueComplete",dueComplete);
        return this;
    }

    public HashMap<String,Object> build()
    {
        return params;
    }


}
