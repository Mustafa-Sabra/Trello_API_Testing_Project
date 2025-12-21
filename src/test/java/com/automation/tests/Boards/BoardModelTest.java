package com.automation.tests.Boards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.pojo.Board;
import com.automation.utils.ResponseUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.automation.utils.ResponseUtils.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BoardModelTest{

    @Test
    public void createBoardSuccessfullyTest(){

        BoardAPI boardAPI = new BoardAPI();
        Response response = boardAPI.createBoard(new CreateBoardParams("my first board 9"),200);

        assertFieldEquals(response,"name", "my first board 9");

    }

    @Test
    public void createBoardWithEmptyNameTest(){

        BoardAPI boardAPI = new BoardAPI();
        boardAPI.createBoard(new CreateBoardParams(""), 400);

    }




}
