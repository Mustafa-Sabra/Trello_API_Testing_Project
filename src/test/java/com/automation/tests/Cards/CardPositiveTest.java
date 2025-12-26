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

public class CardPositiveTest {

    @Test
    public void createCard_withValidListId_shouldReturn200() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        assertFieldNotNull(createCardResponse, "id");
        assertFieldEquals(createCardResponse, "name", "new card");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void deleteCard_withValidCardId_shouldReturn200() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        cardAPI.deleteCard(cardId, ResponseSpecs.success());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void getCard_withValidCardId_shouldReturn200() {

        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();
        CardAPI cardAPI = new CardAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams(listId).name("new card"), ResponseSpecs.created());

        String cardId = createCardResponse.jsonPath().getString("id");

        Response getCardResponse = cardAPI.getCard(cardId, new HashMap<>(),ResponseSpecs.success());

        assertFieldNotNull(getCardResponse,"id");
        assertFieldEquals(getCardResponse,"name", "new card");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void updateCard_withValidCardId_shouldReturn200() {

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

        Response updateCardResponse = cardAPI.updateList(cardId, queryParams,ResponseSpecs.success());

        assertFieldEquals(updateCardResponse,"id", cardId);
        assertFieldEquals(updateCardResponse,"name", "updated card name");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

}
