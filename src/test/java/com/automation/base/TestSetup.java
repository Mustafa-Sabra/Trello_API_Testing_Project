package com.automation.base;


import com.automation.cleanup.CleanupManager;
import com.automation.utils.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSetup {


    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        CleanupManager.clearAll();
    }

}

