package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class UpdateBoardTest  {


    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void updateBoardSuccessfullyTest(ITestContext context)
    {
        BoardAPI boardAPI = new BoardAPI();

        String boardId = (String) context.getAttribute("boardId");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board");

        boardAPI.updateBoard(boardId,queryParams , ResponseSpecs.success() );
    }

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void updateBoardNegativeTest(ITestContext context)
    {
        BoardAPI boardAPI = new BoardAPI();

        String boardId = (String) context.getAttribute("boardId");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board");

        boardAPI.updateBoard(boardId+"b1",queryParams , ResponseSpecs.badRequest() );
    }

}
