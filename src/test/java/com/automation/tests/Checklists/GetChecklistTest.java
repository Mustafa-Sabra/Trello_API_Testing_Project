package com.automation.tests.Checklists;

import com.automation.api.ChecklistAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class GetChecklistTest extends BaseTest {

    @Test
    public void getCheckListTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();

        Response res = new ChecklistAPI().getChecklist("6943fc93e4acb5b8118c4f0f",queryParams );

        assertStatusCode(res, 200);
        assertFieldEquals(res, "name", "Checklist");
        assertFieldNotNull(res,"id");

    }

}
