package com.automation.tests.Boards;

import com.automation.api.BoardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class GetBoardTest extends BaseTest {

    private HashMap<String,String> queryParams = new HashMap<>();


    @Test
    public void getBoardTest()
    {
        Response res = new BoardAPI().getBoard("hxLqvdWP", queryParams);

        assertFieldNotNull(res, "id");
        assertFieldEquals(res, "name", "my test board 3");

    }
}
