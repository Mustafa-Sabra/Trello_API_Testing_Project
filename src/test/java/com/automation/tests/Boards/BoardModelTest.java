package com.automation.tests.Boards;

import com.automation.api.BoardAPI;
import com.automation.base.BaseTest;
import com.automation.pojo.Board;
import com.automation.utils.ResponseUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BoardModelTest extends BaseTest {

    @Test
    public void createBoardTest(){
        Board boardBody = new Board("my test board 5");

        Response res = new BoardAPI().createBoard(boardBody);

        ResponseUtils.assertStatusCode(res,200);

        BoardId = res.jsonPath().get("id");

        System.out.println("✔ Booking created successfully. ID = " + BoardId);

    }




}
