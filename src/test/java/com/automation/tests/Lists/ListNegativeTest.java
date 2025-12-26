package com.automation.tests.Lists;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.automation.utils.ResponseUtils.assertFieldEquals;
import static com.automation.utils.ResponseUtils.assertFieldNotNull;

public class ListNegativeTest {

    @Test
    public void createList_withInvalidBoardId_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId + "id"), ResponseSpecs.badRequest());


        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }

    @Test
    public void createList_withEmptyName_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("", boardId), ResponseSpecs.badRequest());


        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }
    @Test
    public void getList_withInvalidListId_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        listAPI.getList(listId + "s",new HashMap<>(),ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void updateList_withInvalidListId_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "new list name");

        listAPI.updateList(listId + "s",queryParams,ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void updateList_withInvalidClosedValue_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("closed", "yes");

        listAPI.updateList(listId ,queryParams,ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());
    }

    @Test
    public void archiveList_withInvalidValue_shouldReturn400()
    {
        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");


        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("value", "yes");


        Response archiveResponse =  listAPI.archiveOrUnarchiveList(listId,queryParams, ResponseSpecs.badRequest());

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }



}
