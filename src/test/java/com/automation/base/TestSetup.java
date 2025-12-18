package com.automation.base;


import com.automation.utils.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class TestSetup {
    public static RequestSpecification ReqSpecs ;

    @BeforeSuite(alwaysRun = true)
    public void setup (){
        ReqSpecs = new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUri())
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .log(LogDetail.METHOD)
                .build();

    }

}
