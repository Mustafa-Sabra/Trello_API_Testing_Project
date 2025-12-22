package com.automation.tests.Lists;

import com.automation.api.cards.CardAPI;
import com.automation.api.cards.CreateCardParams;
import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class CreateListTest   {




@Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
public void createListSuccessfullyTest(ITestContext context)
{
    String boardId = (String) context.getAttribute("boardId");

    ListAPI listAPI = new ListAPI();

    Response response = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.success());

    context.setAttribute("listId", response.jsonPath().getString("id"));


    assertFieldNotNull(response,"id");


}

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void createListNegativeTest(ITestContext context)
    {
        String boardId = (String) context.getAttribute("boardId");

        ListAPI listAPI = new ListAPI();

        Response response = listAPI.createList(new CreateListParams("", boardId), ResponseSpecs.badRequest());

    }



}
