package com.automation.tests.Cards;

import com.automation.api.cards.CardAPI;
import com.automation.api.cards.CreateCardParams;
import com.automation.client.ResponseSpecs;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateCardTest  {

    @Test (dependsOnMethods = {"com.automation.tests.Boards.BoardModelTest.createBoardSuccessfullyTest"})
    public void createCardTest(ITestContext context)
    {
        String boardId = (String) context.getAttribute("boardId");

        CardAPI cardAPI = new CardAPI();

        cardAPI.createCard(new CreateCardParams(""), ResponseSpecs.created());


    }

}
