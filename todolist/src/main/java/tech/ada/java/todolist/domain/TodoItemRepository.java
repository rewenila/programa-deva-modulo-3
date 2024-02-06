package tech.ada.java.todolist.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional annotation
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
