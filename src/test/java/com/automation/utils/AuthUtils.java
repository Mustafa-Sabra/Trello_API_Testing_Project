package com.automation.utils;

import java.util.HashMap;

public class AuthUtils {


    public static HashMap<String,Object> authUtils()
    {

        HashMap<String,Object> params = new HashMap<>();
        params.put("key", ConfigManager.getApiKey());
        params.put("token", ConfigManager.getApiToken());

        return params;
    }


}
