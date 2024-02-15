package tech.ada.java.todolist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Boolean completed;
    private LocalDateTime createdAt;

    public TodoItem() {
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public TodoItem(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    // Related to factory pattern
    /* public static TodoItem createTodoItem(String title, String description, LocalDate deadline, boolean completed, LocalDateTime createdAt) {
        return new TodoItem(
                title,
                description,
                deadline,
                false,
                LocalDateTime.now());
    }*/

}
