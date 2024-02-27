package tech.ada.java.todolist.domain.todoitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import tech.ada.java.todolist.domain.todolist.TodoList;

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
    private LocalDateTime updatedAt;
    /*@ManyToOne
    @JsonIgnoreProperties(value = "todoItems")
    private TodoList todoList;*/

    public TodoItem() {
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public TodoItem(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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
