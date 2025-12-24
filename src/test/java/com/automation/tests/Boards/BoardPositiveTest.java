package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BoardPositiveTest {

    @Test
    public void createBoard_withValidName_shouldSucceed() {
        BoardAPI boardApi = new BoardAPI();

        Response response = boardApi.createBoard(new CreateBoardParams("my new board"), ResponseSpecs.created());

        assertFieldNotNull(response,"id");
        assertFieldEquals(response, "name", "my new board");

        boardApi.deleteBoard(response.jsonPath().getString("id"), ResponseSpecs.success());

    }

    @Test
    public void deleteBoard_withValidId_shouldSucceed() {
        BoardAPI boardApi = new BoardAPI();

        Response response = boardApi.createBoard(new CreateBoardParams("board to delete"), ResponseSpecs.created());

        String boardId = response.jsonPath().getString("id");
        boardApi.deleteBoard(boardId,ResponseSpecs.success());

    }

    @Test
    public void getBoard_withValidId_shouldSucceed() {
        BoardAPI boardApi = new BoardAPI();

        Response response = boardApi.createBoard(new CreateBoardParams("my new board 2"), ResponseSpecs.created());

        String boardId = response.jsonPath().getString("id");

        boardApi.getBoard(boardId, new HashMap<>(), ResponseSpecs.success());

        assertFieldEquals(response, "name", "my new board 2");

        boardApi.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void updateBoard_withValidId_shouldSucceed() {
        BoardAPI boardApi = new BoardAPI();

        Response createResponse = boardApi.createBoard(new CreateBoardParams("my new board"), ResponseSpecs.created());

        String boardId = createResponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board 2");

        Response updateResponse =boardApi.updateBoard(boardId,queryParams , ResponseSpecs.success());

        assertFieldEquals(updateResponse, "name", "updated board 2");

        boardApi.deleteBoard(boardId, ResponseSpecs.success());


    }

}
