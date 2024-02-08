package tech.ada.java.todolist.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/todo")
public class TodoController {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @PostMapping("/todo-item")
    public ResponseEntity<TodoItem> registerItem(@RequestBody TodoItemRequest request) {

        TodoItem todoItemConverted = new TodoItem();
        todoItemConverted.setTitle(request.title());
        todoItemConverted.setDescription(request.description());
        todoItemConverted.setDeadline(request.deadline());

        TodoItem newTodoItem = todoItemRepository.save(todoItemConverted);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodoItem);
    }

    @GetMapping("/todo-item")
    public List<TodoItem> findAll() {
        List<TodoItem> listWithAll = todoItemRepository.findAll();
        return listWithAll;
    }

}