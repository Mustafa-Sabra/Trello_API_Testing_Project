package com.automation.client;

import com.automation.utils.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

    private RequestSpecFactory() {}

    public static RequestSpecification defaultSpec() {

        return new RequestSpecBuilder()
                    .setBaseUri(ConfigManager.getBaseUri())
                    .setContentType(ContentType.JSON)
                    .addFilter(new AllureRestAssured())
                    .log(LogDetail.URI)
                    .log(LogDetail.BODY)
                    .log(LogDetail.METHOD)
                    .build();

    }

}
