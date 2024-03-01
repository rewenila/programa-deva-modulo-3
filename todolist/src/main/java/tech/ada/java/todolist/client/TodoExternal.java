package tech.ada.java.todolist.client;

public record TodoExternal(Long id, String todo, Boolean completed, Long userId) {
}
