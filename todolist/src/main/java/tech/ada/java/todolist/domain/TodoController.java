package tech.ada.java.todolist.domain;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor // 3rd option: Makes repository dependence mandatory on constructor
@RestController("/todo")
public class TodoController {

    private final TodoItemRepository todoItemRepository; // repository dependence
    private final ModelMapper modelMapper; // modelMapper dependence

    // 1st option: Springs makes the dependence injection via annotation
    @Autowired
    // 2nd option: Constructor injects the dependence, ensuring that Spring will create the controller with the repository, makes @Autowired unnecessary
    public TodoController(TodoItemRepository todoItemRepository, ModelMapper modelMapper) {
        this.todoItemRepository = todoItemRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/todo-item")
    public ResponseEntity<TodoItem> registerItem(@RequestBody TodoItemRequest request) {
        // toEntity method
        // Advantage: you have more control over the process
        // Disadvantage: you need to write a toEntity method for all new requests
        // TodoItem todoItemConverted = request.toEntity();

        // Model mapper
        // Advantage: you can use the method various times
        // Disadvantage: dependence on a framework
        TodoItem todoItemConverted = modelMapper.map(request, TodoItem.class);

        TodoItem newTodoItem = todoItemRepository.save(todoItemConverted);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodoItem);
    }

    @GetMapping("/todo-item")
    public List<TodoItem> findAll() {
        List<TodoItem> listWithAll = todoItemRepository.findAll();
        return listWithAll;
    }

    @PatchMapping("/todo-item/{id}")
    public ResponseEntity<TodoItem> updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateStatusRequest request) throws Exception {
        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);

        if (optionalTodoItem.isPresent()) {
            TodoItem todoItemModified = optionalTodoItem.get();
            if (request.status() != null) todoItemModified.setCompleted(request.status());
            if (request.title() != null) todoItemModified.setTitle(request.title());
            if (request.description() != null) todoItemModified.setDescription(request.description());
            TodoItem todoItemSaved = todoItemRepository.save(todoItemModified);
            return ResponseEntity.ok(todoItemSaved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}