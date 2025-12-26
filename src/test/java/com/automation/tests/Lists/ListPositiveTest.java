package com.automation.tests.Lists;

import com.automation.api.boards.BoardAPI;
import com.automation.api.boards.CreateBoardParams;
import com.automation.api.lists.CreateListParams;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

import static com.automation.utils.ResponseUtils.*;

public class ListPositiveTest {

    @Test
    public void createList_withValidNameAndBoardId_shouldReturn200()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                        .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());


        assertFieldNotNull(createListresponse,"id");
        assertFieldEquals(createListresponse,"name", "my created list");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }

    @Test
    public void archiveList_withValidId_shouldReturn200()
    {
        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");


        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("value", true);


       Response archiveResponse =  listAPI.archiveOrUnarchiveList(listId,queryParams, ResponseSpecs.success());

        assertFieldEquals(archiveResponse, "closed", true);

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }

    @Test
    public void unArchiveList_withValidId_shouldReturn200()
    {
        BoardAPI boardAPI = new BoardAPI();
        ListAPI listAPI = new ListAPI();

        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");


        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());

        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("value", true);


        Response archiveResponse =  listAPI.archiveOrUnarchiveList(listId,queryParams, ResponseSpecs.success());

        assertFieldEquals(archiveResponse, "closed", true);

        queryParams.put("value", false);

        Response unArchiveResponse =  listAPI.archiveOrUnarchiveList(listId,queryParams, ResponseSpecs.success());

        assertFieldEquals(unArchiveResponse, "closed", false);

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }

    @Test
    public void getList_withValidNameAndBoardId_shouldReturn200()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());


        String listId = createListresponse.jsonPath().getString("id");

        Response getListresponse = listAPI.getList(listId, new HashMap<>(), ResponseSpecs.success());

        assertFieldNotNull(getListresponse,"id");
        assertFieldEquals(getListresponse,"name","my created list");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }


    @Test
    public void updateList_withValidNameAndBoardId_shouldReturn200()
    {
        BoardAPI boardAPI = new BoardAPI();
        String boardId = boardAPI.createBoard(new CreateBoardParams("Board 10"), ResponseSpecs.created())
                .jsonPath().getString("id");

        ListAPI listAPI = new ListAPI();

        Response createListresponse = listAPI.createList(new CreateListParams("my created list", boardId), ResponseSpecs.created());


        String listId = createListresponse.jsonPath().getString("id");

        HashMap<String,Object> queryParams = new HashMap<>();
        queryParams.put("name", "updated list");

        Response updateListresponse = listAPI.updateList(listId, queryParams , ResponseSpecs.success());

        assertFieldEquals(updateListresponse,"name","updated list");

        boardAPI.deleteBoard(boardId, ResponseSpecs.success());

    }

}
