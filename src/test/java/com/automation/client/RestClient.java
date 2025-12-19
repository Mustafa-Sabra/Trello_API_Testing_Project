package com.automation.client;

import com.automation.base.TestSetup;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient {

    public static Response get(String path, HashMap<String, ?> params, ResponseSpecification responseSpec) {

        if(responseSpec == null)
        {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .spec(responseSpec)
                .extract().response();

    }

    public static Response post(String path, Object body, HashMap<String, ?> params, ResponseSpecification responseSpec) {

        if(responseSpec == null)
        {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .body(body)
                .log().all()
                .when()
                .post(path)
                .then()
                .log().all()
                .spec(responseSpec)
                .extract().response();

    }

    public static Response post(String path , HashMap<String, ?> params, ResponseSpecification responseSpec) {


        if (responseSpec == null) {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .log().all()
                .when()
                .post(path)
                .then()
                .log().all()
                .spec(responseSpec)
                .extract().response();

    }

    public static Response delete(String path, Map<String,?> params, ResponseSpecification responseSpec) {

        if (responseSpec == null) {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .log().all()
                .when()
                .delete(path)
                .then()
                .log().all()
                .spec(responseSpec)
                .extract().response();

    }

    public static Response update(String path,Object body, HashMap<String, ?> params, ResponseSpecification responseSpec) {

        if (responseSpec == null) {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .body(body)
                .log().all()
                .when()
                .put(path)
                .then()
                .log().all()
                .spec( responseSpec)
                .extract().response();

    }

    public static Response update(String path, HashMap<String, ?> params, ResponseSpecification responseSpec) {

        if (responseSpec == null) {
            throw new IllegalStateException("ResponseSpecification must not be null");
        }

        return  given()
                .spec(RequestSpecFactory.defaultSpec())
                .queryParams(params)
                .log().all()
                .when()
                .put(path)
                .then()
                .log().all()
                .spec( responseSpec)
                .extract().response();

    }

}
