package com.automation.tests.Lists;

import com.automation.api.ListAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class GetListTest extends BaseTest {


    @Test
    public void getListTest()
    {

        HashMap<String,String> queryParams = new HashMap<>();

        Response res = new ListAPI().getList("6943e78a3495122474ebbaf1", queryParams);

        assertStatusCode(res, 200);


    }


}
