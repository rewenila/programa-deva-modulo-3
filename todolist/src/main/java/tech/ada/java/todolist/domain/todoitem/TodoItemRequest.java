package tech.ada.java.todolist.domain.todoitem;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemRequest {

    String title;
    String description;
    LocalDate deadline;

    public TodoItem toEntity() {
        return new TodoItem(title, description, deadline);
    }
}
