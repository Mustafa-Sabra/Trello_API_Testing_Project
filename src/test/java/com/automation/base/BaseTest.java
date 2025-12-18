package com.automation.base;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static String Apikey ;
    protected static String Apitoken ;
    private static String BaseURI = "https://api.trello.com/1";

    protected static RequestSpecification ReqSpecs ;
    protected static String BoardId ;

    @BeforeClass
    public void setup (){
        ReqSpecs = new RequestSpecBuilder()
                .setBaseUri(BaseURI)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .log(LogDetail.METHOD)
                .build();

    }

    public String getCurrentBoardId(String id)
    {
            if(id.isEmpty())
                return BoardId;
            else
                return id;

    }


}
