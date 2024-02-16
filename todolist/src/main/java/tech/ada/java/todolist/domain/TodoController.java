package tech.ada.java.todolist.domain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @PutMapping("/todo-item/{id}")
    public ResponseEntity<TodoItem> updateEntireTodoItem(
            @PathVariable Long id,
            @RequestBody UpdateEntireTodoItemRequest request) throws Exception {
        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);

        if (optionalTodoItem.isPresent()) {
            TodoItem todoItemModified = optionalTodoItem.get();

            todoItemModified.setTitle(request.title());
            todoItemModified.setDescription(request.description());
            todoItemModified.setCompleted(request.completed()    );
            todoItemModified.setDeadline(request.deadline());
            // Both ways below are correct, as well as not updating at all: it depends on business rules
            // todoItemModified.setCreatedAt(request.createdAt());
            // todoItemModified.setCreatedAt(LocalDateTime.now());
            todoItemModified.setUpdatedAt(LocalDateTime.now());

            TodoItem todoItemSaved = todoItemRepository.save(todoItemModified);
            return ResponseEntity.ok(todoItemSaved);
        } else {
            // If id is autoincremented, PUT should only update and not also create, because the created
            // item will have the autoincremented id and not the path variable id
            /* TodoItem todoItemNew = new TodoItem();

            todoItemNew.setTitle(request.title());
            todoItemNew.setDescription(request.description());
            todoItemNew.setCompleted(request.completed());
            todoItemNew.setDeadline(request.deadline());
            todoItemNew.setCreatedAt(request.createdAt());

            TodoItem todoItemSaved = todoItemRepository.save(todoItemNew); */
            return ResponseEntity.notFound().build();
        }
    }

}