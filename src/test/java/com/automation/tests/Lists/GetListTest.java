package com.automation.tests.Lists;

import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldNotNull;

public class GetListTest {

    @Test (dependsOnMethods = {"com.automation.tests.Lists.CreateListTest.createListSuccessfullyTest",
                                "com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void getListSuccessfullyTest(ITestContext context)
    {
        String listId = (String) context.getAttribute("listId");

        ListAPI listAPI = new ListAPI();

        Response response = listAPI.getList(listId, new HashMap<>(), ResponseSpecs.success());

        assertFieldNotNull(response,"id");

    }

    @Test (dependsOnMethods = {"com.automation.tests.Lists.CreateListTest.createListSuccessfullyTest",
            "com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void getListNegativeTest(ITestContext context)
    {
        String listId = (String) context.getAttribute("listId");

        ListAPI listAPI = new ListAPI();

        Response response = listAPI.getList(listId+"d", new HashMap<>(),ResponseSpecs.badRequest());

    }






}
