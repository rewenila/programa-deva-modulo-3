package tech.ada.java.todolist.todoitem;

import lombok.Getter;

@Getter
public class ItemPutInListRequest {
    private Long itemId;
    private Long listId;
}
