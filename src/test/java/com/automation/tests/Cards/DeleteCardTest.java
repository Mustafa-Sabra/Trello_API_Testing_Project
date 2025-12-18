package com.automation.tests.Cards;

import com.automation.api.CardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertStatusCode;

public class DeleteCardTest extends BaseTest {


    @Test
    public void deleteCardTest()
    {
        Response res = new CardAPI().deleteCard("6943f9c0c47c59908cf9f425");

        assertStatusCode(res,200);
    }


}
