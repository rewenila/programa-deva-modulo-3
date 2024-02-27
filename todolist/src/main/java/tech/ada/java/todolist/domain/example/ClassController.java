package tech.ada.java.todolist.domain.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    public ClassController(ClassRepository classRepository, StudentRepository studentRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/class")
    public Class registerClass(@RequestBody String name) {
        var studentClass = new Class();
        studentClass.setName(name);
        var students = studentRepository.findAll();
        // studentClass.setStudents(students);
        return classRepository.save(studentClass);
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody String name) {
        var student = new Student();
        var classes = classRepository.findAll().getFirst();

        student.setName(name);
        // student.setStudentClass(classes);

        return studentRepository.save(student);
    }

    @GetMapping("/class")
    public List<Class> getStudentClass() {
        return classRepository.findAll();
    }

    @GetMapping("/student")
    public List<Student> getStudent() {
        Student studentFulano = studentRepository.findById(1l).get();
        Class classAda = studentFulano.getStudentClass();
        classAda.getId();
        classAda.getName();
        return studentRepository.findAll();
    }

}
