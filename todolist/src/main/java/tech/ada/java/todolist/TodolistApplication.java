package tech.ada.java.todolist;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.ada.java.todolist.domain.TodoController;
import tech.ada.java.todolist.domain.TodoItemRepository;

@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }

    // modelMapper configuration Bean, it teaches Spring how to create the modelMapper
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
