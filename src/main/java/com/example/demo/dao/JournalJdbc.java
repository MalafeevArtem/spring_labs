package com.example.demo.dao;

import com.example.demo.model.Group;

import com.example.demo.model.Journal;
import com.example.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
public class JournalJdbc {

    private final JdbcTemplate jdbcTemplate;

    public JournalJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Journal mapJournal(ResultSet rs, int i) throws SQLException {
        Journal journal = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );

        return journal;
    }


    // Вывод записи журнала
    public Journal getJournal(int id) {
        return jdbcTemplate.queryForObject("SELECT student.name, student.surname,  FROM journal WHERE id = ?", this::mapJournal, id);
    }


    // Вывод всех записей журнала
    public List<Journal> getAllJournal() {
        return jdbcTemplate.query("SELECT * FROM journal", this::mapJournal);
    }


    // Добавление новой записи в журнал
    public int createJournal(Journal journal) {
        return jdbcTemplate.update("INSERT INTO journal VALUES(?, ?, ?, ?, ?, ?)",
                journal.getId(), journal.getStudent_id(),
                journal.getStudy_plan_id(), journal.isIn_time(), journal.getCount(), journal.getMark_id());

    }

    // Вывод записей для группы
    public List<Journal> getJournalByGroup(int id) {
        return jdbcTemplate.query("SELECT * FROM journal " +
                "INNER JOIN student ON journal.student_id = student.id " +
                "WHERE study_group_id = ?", this::mapJournal, id);
    }

    // Вывод записей для группы
    public List<Journal> getJournalByStudent(int id) {
        return jdbcTemplate.query("SELECT * FROM journal " +
                "WHERE student_id = ?", this::mapJournal, id);
    }


    // Редактирование записи журнаоа
    public int updateJournal(int id, Journal journal) {
        return jdbcTemplate.update("UPDATE journal SET mark_id = ? WHERE id = ?",
                journal.getMark_id(), id);
    }
}
