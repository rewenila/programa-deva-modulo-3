package tech.ada.java.todolist.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
