package com.example.demo.controller;


import com.example.demo.dao.StudentJdbc;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc) {
        this.studentJdbc = studentJdbc;
    }

    // Создание студента
    @PostMapping("/student")
    public int addStudent(@RequestBody Student student) {
        return studentJdbc.create(student);
    }

    // Просмотр студента
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentJdbc.get(id);

        return student;
    }

    // Просмотр всех студентов
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentJdbc.getAll();
    }

    // Просмотр студента по группе
    @GetMapping("/students_group/{id}")
    public List<Student> getAllStudentsGroup(@PathVariable int id) {
        return studentJdbc.getStudentsGroup(id);
    }

    // Редактирование студента
    @PutMapping("/student/{id}")
    public int updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentJdbc.update(id, student);
    }

    // Удаление студента
    @DeleteMapping("/student/{id}")
    public int deleteStudent(@PathVariable int id) {
        return studentJdbc.delete(id);
    }
}
