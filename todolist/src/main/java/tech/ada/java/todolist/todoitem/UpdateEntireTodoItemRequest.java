package tech.ada.java.todolist.todoitem;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/*@Getter
@Setter
public class UpdateEntireTodoItemRequest {
    // 1st option to ensure that no argument will be null:
    // @NotNull annotation, which depends on a library
    String title;
    String description;
    Boolean completed;
    LocalDate deadline;

    // 2nd option to ensure that no argument will be null: constructor
    // Obs: Spring uses complete constructor if we remove the default
    public UpdateEntireTodoItemRequest(String title, String description, Boolean completed, LocalDate deadline) {
        this.title = Objects.requireNonNull(title, "Title is mandatory.");
        this.description = Objects.requireNonNull(description, "Description is mandatory.");
        this.completed = Objects.requireNonNull(completed, "Completed is mandatory.");
        this.deadline = Objects.requireNonNull(deadline, "Deadline is mandatory.");
    }

}*/

public record UpdateEntireTodoItemRequest (
    // 1st option to ensure that no argument will be null:
    // @NotNull annotation, which depends on a library
    String title,
    String description,
    Boolean completed,
    LocalDate deadline
) {
    // 2nd option to ensure that no argument will be null: constructor
    public UpdateEntireTodoItemRequest(String title, String description, Boolean completed, LocalDate deadline) {
        this.title = Objects.requireNonNull(title, "Title is mandatory.");
        this.description = Objects.requireNonNull(description, "Description is mandatory.");
        this.completed = Objects.requireNonNull(completed, "Completed is mandatory.");
        this.deadline = Objects.requireNonNull(deadline, "Deadline is mandatory.");
    }
}