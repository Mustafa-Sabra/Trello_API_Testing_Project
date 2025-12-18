package com.automation.tests.Boards;

import com.automation.api.BoardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.automation.utils.ResponseUtils.assertStatusCode;

public class DeleteBoardTest extends BaseTest {


    @Test
    public void deleteBoard()
    {
        Response res = new BoardAPI().deleteBoard("chIvMWNx");

        assertStatusCode(res, 200);

    }
}
