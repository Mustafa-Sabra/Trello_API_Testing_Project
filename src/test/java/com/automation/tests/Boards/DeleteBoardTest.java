package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static com.automation.utils.ResponseUtils.assertStatusCode;

public class DeleteBoardTest {


    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void deleteBoardSuccefullyTest(ITestContext context)
    {
        BoardAPI boardAPI = new BoardAPI();

        String boardId = (String)context.getAttribute("boardId");

        boardAPI.deleteBoard( boardId, ResponseSpecs.success());


    }

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void deleteBoardNegativeTest(ITestContext context)
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = (String)context.getAttribute("boardId");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

        Response response = boardAPI.deleteBoard(boardId, ResponseSpecs.notFound());


    }
}
