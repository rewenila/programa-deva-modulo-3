package tech.ada.java.todolist.domain.todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolist.client.Result;
import tech.ada.java.todolist.client.TodoExternal;
import tech.ada.java.todolist.client.TodoRestClient;
import tech.ada.java.todolist.domain.todoitem.TodoItem;
import tech.ada.java.todolist.domain.todoitem.TodoItemRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    private TodoListRepository todoListRepository;
    private TodoItemRepository todoItemRepository;
    private TodoRestClient todoRestClient;

    public TodoListController(TodoListRepository todoListRepository,
                              TodoItemRepository todoItemRepository,
                              TodoRestClient todoRestClient) {
        this.todoListRepository = todoListRepository;
        this.todoItemRepository = todoItemRepository;
        this.todoRestClient = todoRestClient;
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

    @GetMapping("/todo-external")
    public List<TodoItem> findAllExernal() {
        // One way to do it: procedural
        Result result = todoRestClient.getAllTodos();

        List<TodoItem> listReturn = new ArrayList<>();
        for (TodoExternal todoExternal: result.todos()) {
            TodoItem newItem = convert(todoExternal);
            todoItemRepository.save(newItem);
            listReturn.add(newItem);
        }

        // Other way: functional
        /*List<TodoExternal> todoExternalList = todoRestClient.getAllTodos().todos();
        todoExternalList.stream()
                .map(this::convert)
                .forEach(this.todoItemRepository::save);*/

        return listReturn;
    }

    private TodoItem convert(TodoExternal todoExternal) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(todoExternal.todo());
        todoItem.setDescription("Description: " + todoExternal.todo());
        todoItem.setCompleted(todoExternal.completed());
        return todoItem;
    }
}
