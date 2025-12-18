package com.automation.tests.Checklists;

import com.automation.api.ChecklistAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertStatusCode;

public class DeleteChecklistTest extends BaseTest {

    @Test
    public void deleteCheckListTest()
    {

        Response res = new ChecklistAPI().deleteChecklist("6943fc93e4acb5b8118c4f0f" );

        assertStatusCode(res, 200);

    }

}
