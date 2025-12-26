package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertFieldNotNull;

public class BoardNegativeTest {

    @Test
    public void createBoard_withEmptyName_shouldReturn400() {
        BoardAPI boardApi = new BoardAPI();

        boardApi.createBoard(new CreateBoardParams(""), ResponseSpecs.badRequest());

    }

    @Test
    public void deleteBoard_withInvalidId_shouldReturn400() {
        BoardAPI boardApi = new BoardAPI();

        Response response = boardApi.createBoard(new CreateBoardParams("board to delete"), ResponseSpecs.created());

        String boardId = response.jsonPath().getString("id");
        boardApi.deleteBoard(boardId + "d",ResponseSpecs.badRequest());

    }

    @Test
    public void getBoard_withInvalidId_shouldReturn400() {
        BoardAPI boardApi = new BoardAPI();

        Response response = boardApi.createBoard(new CreateBoardParams("my new board 2"), ResponseSpecs.created());

        String boardId = response.jsonPath().getString("id");

        boardApi.getBoard(boardId + "s", new HashMap<>(), ResponseSpecs.badRequest());

    }

    @Test
    public void updateBoard_withInvalidId_shouldReturn400() {
        BoardAPI boardApi = new BoardAPI();

        Response createResponse = boardApi.createBoard(new CreateBoardParams("my new board"), ResponseSpecs.created());

        String boardId = createResponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board 2");

         boardApi.updateBoard(boardId+"1",queryParams , ResponseSpecs.badRequest());
    }


}
