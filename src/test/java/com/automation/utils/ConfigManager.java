package com.automation.utils;

import tools.jackson.databind.annotation.JsonAppend;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties"))
        {
            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }


    public static String getBaseUri()
    {
        return properties.getProperty("base.uri");
    }

    public static String getApiKey()
    {
        return properties.getProperty("trello.key");
    }

    public static String getApiToken()
    {
        return properties.getProperty("trello.token");
    }


}
