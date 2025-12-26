package com.automation.tests.Checklists;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.api.cards.CardAPI;
import com.automation.api.cards.CreateCardParams;
import com.automation.api.checklists.ChecklistAPI;
import com.automation.api.checklists.CreateCheckListParams;
import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertFieldNotNull;

public class ChecklistNegativeTest {

    @Test
    public void createChecklist_withInvalidCardId_shouldReturn400()
    {

        BoardAPI boardAPI        = new BoardAPI();
        ListAPI listAPI         = new ListAPI();
        CardAPI cardAPI         = new CardAPI();
        ChecklistAPI checklistAPI    = new ChecklistAPI();

        Response createBoardResponse = boardAPI.createBoard(new CreateBoardParams("new board"), ResponseSpecs.created());
        String boardId = createBoardResponse.jsonPath().getString("id");

        Response createListResponse = listAPI.createList(new CreateListParams("new list", boardId), ResponseSpecs.created());
        String listId = createListResponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams( listId).name("new card"), ResponseSpecs.created());
        String cardId = createCardResponse.jsonPath().getString("id");

        checklistAPI.createChecklist(new CreateCheckListParams(cardId+"o").name("new checklist"), ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId,ResponseSpecs.success());

    }

    @Test
    public void createChecklist_withInvalidPos_shouldReturn400()
    {

        BoardAPI boardAPI        = new BoardAPI();
        ListAPI listAPI         = new ListAPI();
        CardAPI cardAPI         = new CardAPI();
        ChecklistAPI checklistAPI    = new ChecklistAPI();

        Response createBoardResponse = boardAPI.createBoard(new CreateBoardParams("new board"), ResponseSpecs.created());
        String boardId = createBoardResponse.jsonPath().getString("id");

        Response createListResponse = listAPI.createList(new CreateListParams("new list", boardId), ResponseSpecs.created());
        String listId = createListResponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams( listId).name("new card"), ResponseSpecs.created());
        String cardId = createCardResponse.jsonPath().getString("id");

        checklistAPI.createChecklist(new CreateCheckListParams(cardId).name("new checklist").pos(-50), ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId,ResponseSpecs.success());

    }

    @Test
    public void updateChecklist_withInvalidId_shouldReturn400()
    {

        BoardAPI        boardAPI        = new BoardAPI();
        ListAPI         listAPI         = new ListAPI();
        CardAPI         cardAPI         = new CardAPI();
        ChecklistAPI    checklistAPI    = new ChecklistAPI();

        Response createBoardResponse = boardAPI.createBoard(new CreateBoardParams("new board"), ResponseSpecs.created());
        String boardId = createBoardResponse.jsonPath().getString("id");

        Response createListResponse = listAPI.createList(new CreateListParams("new list", boardId), ResponseSpecs.created());
        String listId = createListResponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams( listId).name("new card"), ResponseSpecs.created());
        String cardId = createCardResponse.jsonPath().getString("id");

        Response createChecklistResponse = checklistAPI.createChecklist(new CreateCheckListParams(cardId).name("new checklist"), ResponseSpecs.created());
        String checklistId = createChecklistResponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated checklist");

        checklistAPI.updateChecklist(checklistId+"o", queryParams, ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId,ResponseSpecs.success());

    }

    @Test
    public void getChecklist_withInvalidId_shouldReturn400()
    {

        BoardAPI        boardAPI        = new BoardAPI();
        ListAPI         listAPI         = new ListAPI();
        CardAPI         cardAPI         = new CardAPI();
        ChecklistAPI    checklistAPI    = new ChecklistAPI();

        Response createBoardResponse = boardAPI.createBoard(new CreateBoardParams("new board"), ResponseSpecs.created());
        String boardId = createBoardResponse.jsonPath().getString("id");

        Response createListResponse = listAPI.createList(new CreateListParams("new list", boardId), ResponseSpecs.created());
        String listId = createListResponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams( listId).name("new card"), ResponseSpecs.created());
        String cardId = createCardResponse.jsonPath().getString("id");

        Response createChecklistResponse = checklistAPI.createChecklist(new CreateCheckListParams(cardId).name("new checklist"), ResponseSpecs.created());
        String checklistId = createChecklistResponse.jsonPath().getString("id");

        checklistAPI.getChecklist(checklistId+"s", new HashMap<>(), ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId,ResponseSpecs.success());

    }

    @Test
    public void deleteChecklist_withInvalidId_shouldReturn400()
    {

        BoardAPI        boardAPI        = new BoardAPI();
        ListAPI         listAPI         = new ListAPI();
        CardAPI         cardAPI         = new CardAPI();
        ChecklistAPI    checklistAPI    = new ChecklistAPI();

        Response createBoardResponse = boardAPI.createBoard(new CreateBoardParams("new board"), ResponseSpecs.created());
        String boardId = createBoardResponse.jsonPath().getString("id");

        Response createListResponse = listAPI.createList(new CreateListParams("new list", boardId), ResponseSpecs.created());
        String listId = createListResponse.jsonPath().getString("id");

        Response createCardResponse = cardAPI.createCard(new CreateCardParams( listId).name("new card"), ResponseSpecs.created());
        String cardId = createCardResponse.jsonPath().getString("id");

        Response createChecklistResponse = checklistAPI.createChecklist(new CreateCheckListParams(cardId).name("new checklist"), ResponseSpecs.created());
        String checklistId = createChecklistResponse.jsonPath().getString("id");

        checklistAPI.deleteChecklist(checklistId + "d",  ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId,ResponseSpecs.success());

    }

}
