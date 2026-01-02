package com.automation.cleanup;

import com.automation.api.boards.BoardAPI;
import com.automation.api.cards.CardAPI;
import com.automation.api.checklists.ChecklistAPI;
import com.automation.api.lists.ListAPI;
import com.automation.client.ResponseSpecs;

import java.util.HashMap;

public class CleanupManager {


    public static void clearAll() {

        CleanupContext.getChecklists().forEach(CleanupManager::safeDeleteChecklist);
        CleanupContext.getCards().forEach(CleanupManager::safeDeleteCard);
        CleanupContext.getLists().forEach(CleanupManager::safeDeleteList);
        CleanupContext.getBoards().forEach(CleanupManager::safeDeleteBoard);



        }


    private static void safeDeleteBoard(String boardId) {
        try {
            BoardAPI boardAPI = new BoardAPI();
            boardAPI.deleteBoard(boardId, ResponseSpecs.success());
        } catch (Exception ignored) {
        }
    }
    private static void safeDeleteList(String listId) {
        try {
            ListAPI listAPI = new ListAPI();
            HashMap <String,Object> queryParams = new HashMap<>();

            queryParams.put("value", true);

            listAPI.archiveOrUnarchiveList(listId,queryParams,ResponseSpecs.success());
        } catch (Exception ignored) {
        }
    }

    private static void safeDeleteCard(String cardId) {
        try {
            CardAPI cardAPI = new CardAPI();
            cardAPI.deleteCard(cardId, ResponseSpecs.success());
        } catch (Exception ignored) {
        }
    }

    private static void safeDeleteChecklist(String checklistId) {
        try {
            ChecklistAPI checklistAPI = new ChecklistAPI();
            checklistAPI.deleteChecklist(checklistId, ResponseSpecs.success());
        } catch (Exception ignored) {
        }
    }




}
