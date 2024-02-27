package tech.ada.java.todolist.domain.todolist;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ada.java.todolist.domain.todoitem.TodoItem;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    @OneToMany
    private List<TodoItem> todoItems;
    private Long priority;

}

/*
Relationship between tables:
1:1: Student and enrollment number
1:N: Student and courses
N:N: Students and professors
*/
