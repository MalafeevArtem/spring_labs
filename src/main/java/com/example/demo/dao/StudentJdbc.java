package com.example.demo.dao;


import com.example.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbc {

    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    // Вывод одного студента
    public Student get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    // Добавление нового студента
    public int create(Student student) {
        return jdbcTemplate.update("INSERT INTO student VALUES(?, ?, ?, ?, ?)",
                student.getId(), student.getSurname(),
                student.getSecond_name(), student.getStudy_group_id(), student.getName());

    }

    // Вывод всех студентов
    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student", this::mapStudent);
    }

//    // Вывод всех студентов
//    public List<Student> getAllLocal() {
//        return jdbcTemplate.query("SELECT * FROM student_local", this::mapStudent);
//    }


    // Вывод всех студентов определенной группы
    public List<Student> getStudentsGroup(int id) {
        return jdbcTemplate.query("SELECT * FROM student " +
                "INNER JOIN study_group ON student.study_group_id = study_group.id " +
                "WHERE study_group_id = ?", this::mapStudent, id);
    }

    // Удаление студента
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }

    // Обновление данные о студенте
    public int update(int id, Student student) {
        return jdbcTemplate.update("UPDATE student SET surname = ?, second_name = ?," +
                "study_group_id = ?, name = ? WHERE id = ?", student.getSurname(),
                student.getSecond_name(), student.getStudy_group_id(), student.getName(), id);
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException {
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("second_name"),
                rs.getInt("study_group_id"),
                rs.getString("name")
        );

        return student;
    }
}
