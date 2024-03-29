package tech.ada.java.todolist;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
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
