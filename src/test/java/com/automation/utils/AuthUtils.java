package com.automation.utils;

import java.util.HashMap;

public class AuthUtils {


    public static HashMap<String,String> authUtils()
    {

        HashMap<String,String> params = new HashMap<>();
        params.put("key", ConfigManager.getApiKey());
        params.put("token", ConfigManager.getApiToken());

        return params;
    }


}
