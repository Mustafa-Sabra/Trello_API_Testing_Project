package com.automation.tests.Cards;

import com.automation.api.CardAPI;
import com.automation.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.*;

public class CreateCardTest extends BaseTest {

    @Test
    public void createCardTest()
    {
        HashMap<String,String> queryParams = new HashMap<>();
        queryParams.put("name", "card1");

        Response res = new CardAPI().createCard("6943e78a3495122474ebbaf1", queryParams);

        assertStatusCode(res,200);
        assertFieldEquals(res,"name", "card1");
    }

}
