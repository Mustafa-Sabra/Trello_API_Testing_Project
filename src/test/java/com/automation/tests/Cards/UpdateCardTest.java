package com.automation.tests.Cards;

import com.automation.api.CardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertStatusCode;

public class UpdateCardTest extends BaseTest {

    @Test
    public void updateCardTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();
        queryParams.put("name", "card2");

        Response res = new CardAPI().updateCard("6943f9c0c47c59908cf9f425", queryParams);

        assertStatusCode(res,200);
        assertFieldEquals(res,"name", "card2");
    }

}
