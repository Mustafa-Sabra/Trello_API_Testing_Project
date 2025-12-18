package com.automation.tests.Checklists;

import com.automation.api.ChecklistAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class UpdateChecklistTest extends BaseTest {

    @Test
    public void updateCheckListTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();
        queryParams.put("name", "my new Checklist");

        Response res = new ChecklistAPI().updateChecklist("6943fc93e4acb5b8118c4f0f",queryParams );

        assertStatusCode(res, 200);
        assertFieldEquals(res, "name", "my new Checklist");
        assertFieldEquals(res, "id", "6943fc93e4acb5b8118c4f0f");

    }

}
