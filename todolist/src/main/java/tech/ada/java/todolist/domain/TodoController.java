package tech.ada.java.todolist.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/todo")
public class TodoController {

    private final TodoItemRepository todoItemRepository;

    public TodoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("/todo-item")
    public void InserirTodoItem(String title) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("acordar");

        todoItemRepository.save(todoItem);
    }

}
