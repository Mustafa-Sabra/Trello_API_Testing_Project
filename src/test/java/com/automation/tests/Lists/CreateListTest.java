package com.automation.tests.Lists;

import com.automation.api.ListAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class CreateListTest extends BaseTest {

    private HashMap<String,String> queryParams = new HashMap<>();

    @Test
    public void createListTest()
    {
        Response res = new ListAPI().createList("created list", "6943238513a09eabfd543eb2", queryParams);

        assertStatusCode(res, 200);
        assertFieldNotNull(res,"id");
        assertFieldEquals(res,"name", "created list");

    }

}
