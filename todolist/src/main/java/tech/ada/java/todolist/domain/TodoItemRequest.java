package tech.ada.java.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

record TodoItemRequest (
        String title,
        String description,
        LocalDate deadline
) {
}
