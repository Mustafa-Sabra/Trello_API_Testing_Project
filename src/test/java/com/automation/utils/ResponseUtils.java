package com.automation.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResponseUtils {

    public static void assertStatusCode (Response response, int expectedStatusCode)
    {
        assertThat( "Unexpected status code" , response.statusCode(), is(expectedStatusCode));
    }

    public static void assertFieldNotNull (Response response, String field)
    {
        assertThat( JsonPath.from(response.asString()).getString(field), notNullValue());
    }

    public static void assertFieldEquals (Response response, String field, Object expected)
    {
        assertThat(response.jsonPath().get(field), equalTo(expected));
    }



}
