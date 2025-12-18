package com.automation.tests.Checklists;

import com.automation.api.ChecklistAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class CreateChecklistTest extends BaseTest {

    @Test
    public void createCheckListTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();
        queryParams.put("name", "my checklist");

        Response res = new ChecklistAPI().createChecklist("6943fb30d28bfbc49e4765b0",queryParams );

        assertStatusCode(res, 200);
        assertFieldEquals(res, "name", "my checklist");
        assertFieldNotNull(res,"id");

    }

}
