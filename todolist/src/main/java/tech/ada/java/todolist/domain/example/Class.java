package tech.ada.java.todolist.domain.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //@OneToMany(mappedBy = "class")
    @OneToMany
    private List<Student> students;
}
