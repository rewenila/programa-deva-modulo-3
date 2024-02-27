package tech.ada.java.todolist.domain.todoitem;

import lombok.Getter;

@Getter
public class ItemPutInListRequest {
    private Long itemId;
    private Long listId;
}
