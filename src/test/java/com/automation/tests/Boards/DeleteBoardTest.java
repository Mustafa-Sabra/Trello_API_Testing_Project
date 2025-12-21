package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.automation.utils.ResponseUtils.assertStatusCode;

public class DeleteBoardTest {


    @Test
    public void deleteBoardSuccefullyTest()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("my first board"),200).jsonPath().getString("id");

        boardAPI.deleteBoard("boardId",200);


    }

    @Test
    public void deleteBoardNegativeTest()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("my first board"),200).jsonPath().getString("id");

        boardAPI.deleteBoard(boardId, 200);

        Response response = boardAPI.deleteBoard(boardId, 404);


    }
}
