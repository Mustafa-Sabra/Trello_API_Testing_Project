package com.automation.client;

import com.automation.base.TestSetup;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient {

    public static Response get(String path, HashMap<String, ?> params) {

        return  given()
                .spec(TestSetup.ReqSpecs)
                .queryParams(params)
                .when()
                .get(path)
                .then()
                .extract().response();

    }

    public static Response post(String path, Object body, HashMap<String, ?> params) {

        return  given()
                .spec(TestSetup.ReqSpecs)
                .queryParams(params)
                .body(body)
                .when()
                .post(path)
                .then()
                .extract().response();

    }

    public static Response delete(String path,String id) {

        return  given()
                .spec(TestSetup.ReqSpecs)
                .when()
                .delete(path + id)
                .then()
                .extract().response();

    }

    public static Response update(String path,String id,Object body, HashMap<String, ?> params) {

        return  given()
                .spec(TestSetup.ReqSpecs)
                .queryParams(params)
                .body(body)
                .when()
                .put(path + id)
                .then()
                .extract().response();

    }

}
