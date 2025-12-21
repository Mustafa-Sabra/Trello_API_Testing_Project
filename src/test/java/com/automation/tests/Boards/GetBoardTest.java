package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class GetBoardTest {

    @Test
    public void getBoardSuccessfullyTest()
    {

        BoardAPI boardAPI = new BoardAPI();
        String id =  boardAPI.createBoard(new CreateBoardParams("get board test"), 200).jsonPath().getString("id");

        Response response = boardAPI.getBoard(id, new HashMap<>(),200);

        assertFieldEquals(response, "name", "get board test");

    }

    @Test
    public void getBoardNegativeTest()
    {

        BoardAPI boardAPI = new BoardAPI();
        String id =  boardAPI.createBoard(new CreateBoardParams("get board test"), 200).jsonPath().getString("id");

        Response response = boardAPI.getBoard(id+"k5", new HashMap<>(),400);


    }

}
