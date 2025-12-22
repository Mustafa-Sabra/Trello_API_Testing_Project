package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class GetBoardTest {

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void getBoardSuccessfullyTest(ITestContext context)
    {

        BoardAPI boardAPI = new BoardAPI();
        String boardId = (String) context.getAttribute("boardId");

        Response response = boardAPI.getBoard(boardId, new HashMap<>(), ResponseSpecs.success());

    }

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void getBoardNegativeTest(ITestContext context)
    {

        BoardAPI boardAPI = new BoardAPI();
        String boardId = (String) context.getAttribute("boardId");

        Response response = boardAPI.getBoard(boardId+"k5", new HashMap<>(),ResponseSpecs.badRequest());


    }

}
