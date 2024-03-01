package tech.ada.java.todolist.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "different_name", nullable = false)
    private String name;
    //@Email
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class studentClass;
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
