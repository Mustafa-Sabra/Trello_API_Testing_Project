package com.automation.tests.Lists;

import com.automation.api.ListAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class UpdateListTest extends BaseTest {

    @Test
    public void updateListTest()
    {

        HashMap<String,String> queryParams = new HashMap<>();
        queryParams.put("name", "Updated list 2");


        Response res = new ListAPI().updateList("6943e78a3495122474ebbaf1",queryParams);

        assertStatusCode(res,200);
        assertFieldEquals(res, "name", "Updated list 2");

    }

}
