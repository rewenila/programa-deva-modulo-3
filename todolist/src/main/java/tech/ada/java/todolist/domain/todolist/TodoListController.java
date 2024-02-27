package tech.ada.java.todolist.domain.todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolist.domain.todoitem.TodoItemRepository;

@RestController
public class TodoListController {

    private TodoListRepository todoListRepository;
    private TodoItemRepository todoItemRepository;

    public TodoListController(TodoListRepository todoListRepository, TodoItemRepository todoItemRepository) {
        this.todoListRepository = todoListRepository;
        this.todoItemRepository = todoItemRepository;
    }

    @PostMapping("/todo-list")
    public ResponseEntity<TodoList> createList(@RequestBody TodoListRequest request) {
        var todoList = new TodoList();
        todoList.setName(request.getName());

        // var todoItems = todoItemRepository.findAll();
        // todoList.setTodoItems(todoItems);

        var todoListSaved = todoListRepository.save(todoList);

        return ResponseEntity.ok(todoListSaved);
    }
}
