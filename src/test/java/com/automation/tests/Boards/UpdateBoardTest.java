package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class UpdateBoardTest  {


    @Test
    public void updateBoardSuccessfullyTest()
    {
        BoardAPI boardAPI = new BoardAPI();
        Response response = boardAPI.createBoard(new CreateBoardParams("update board test"), 200);

        String id =response.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board");

        boardAPI.updateBoard(id,queryParams , 200 );
    }

    @Test
    public void updateBoardNegativeTest()
    {
        BoardAPI boardAPI = new BoardAPI();
        Response response = boardAPI.createBoard(new CreateBoardParams("update board test"), 200);

        String id =response.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated board");

        boardAPI.updateBoard(id+"b1",queryParams , 400 );
    }

}
