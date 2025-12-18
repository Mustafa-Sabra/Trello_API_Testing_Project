package com.automation.tests.Cards;

import com.automation.api.CardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertStatusCode;

public class GetCardTest extends BaseTest {

    @Test
    public void getCardTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();

        Response res = new CardAPI().getCard("6943f9c0c47c59908cf9f425", queryParams);

        assertStatusCode(res,200);
        assertFieldEquals(res,"name", "card1");
    }

}
