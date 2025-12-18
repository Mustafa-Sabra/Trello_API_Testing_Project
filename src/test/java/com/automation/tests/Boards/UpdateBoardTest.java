package com.automation.tests.Boards;

import com.automation.api.BoardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class UpdateBoardTest extends BaseTest {


    @Test
    public void updateBoard()
    {
        HashMap <String,String> queryParams = new HashMap<>();
        queryParams.put("name", "momo 4");
        queryParams.put("idOrganization", "workspace68251455" );

        Response res = new BoardAPI().updateBoard("hxLqvdWP",queryParams);

        assertStatusCode(res, 200);
        assertFieldNotNull(res, "id");
        assertFieldEquals(res, "name", "momo 4");
    }

}
