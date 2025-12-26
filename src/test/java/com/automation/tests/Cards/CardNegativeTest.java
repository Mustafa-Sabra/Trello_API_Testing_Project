package com.automation.tests.Cards;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.api.cards.CardAPI;
import com.automation.api.cards.CreateCardParams;
import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertFieldNotNull;

public class CardNegativeTest {

    @Test
    public void createCard_withInvalidListId_shouldReturn400() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId+"s").name("new card"), ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void deleteCard_withInvalidCardId_shouldReturn400() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        cardAPI.deleteCard(cardId + "e", ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void getCard_withInvalidCardId_shouldReturn400() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        Response getCardResponse = cardAPI.getCard(cardId + "w", new HashMap<>(),ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void getCard_withInvalidMembersValue_shouldReturn400() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("members", "yes");

        cardAPI.getCard(cardId , queryParams ,ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void updateCard_withInvalidCardId_shouldReturn400() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated card name");

       cardAPI.updateList(cardId + "o1", queryParams,ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

}
