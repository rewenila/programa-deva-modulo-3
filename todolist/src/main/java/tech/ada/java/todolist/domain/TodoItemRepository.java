package tech.ada.java.todolist.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // optional annotation
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

    // Three ways: JPA, @Query, and native query
    // JPA
    public List<TodoItem> findByTitleIgnoreCase(String title);

    // @Query annotation
    @Query("SELECT t FROM TodoItem t WHERE t.title = ?1")
    public List<TodoItem> findByTitleQuery(String title);

    // Todo: solve problem here
    // Native query: not recommended because it depends on the specific database
    // @Query(value = "SELECT * FROM todo_item WHERE title = ?1", nativeQuery = true)
    // public List<TodoItem> findByTitleQueryNative(String title);
}

