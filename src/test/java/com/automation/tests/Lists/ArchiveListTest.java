package com.automation.tests.Lists;

import com.automation.api.ListAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.automation.utils.ResponseUtils.*;

public class ArchiveListTest extends BaseTest {


    @Test
    public void archiveListTest()
    {

        Response res = new ListAPI().archiveList("6943e78a3495122474ebbaf1");

        assertStatusCode(res, 200);
        assertFieldEquals(res, "closed", true);




    }


}
