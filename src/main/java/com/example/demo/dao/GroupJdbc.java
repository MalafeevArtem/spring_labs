package com.example.demo.dao;

import com.example.demo.model.Group;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroupJdbc {

    private final JdbcTemplate jdbcTemplate;

    public GroupJdbc(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    private Group mapGroup(ResultSet rs, int i) throws SQLException {
        Group group = new Group(
                rs.getInt("id"),
                rs.getString("name")
        );

        return group;
    }

    // Просмотр группы
    public Group get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM " +
                "study_group WHERE id = ?", this::mapGroup, id);
    }

    // Просмотр всех групп
    public List<Group> getAll() {
        return jdbcTemplate.query("SELECT * FROM study_group", this::mapGroup);
    }

    // Редактирование группы
    public int updateGroup(int id, Group group) {
        return jdbcTemplate.update("UPDATE study_group SET name = ? WHERE id = ?",
                group.getName(), id);
    }

    // Создание группы
    public int createGroup(Group group) {
        return jdbcTemplate.update("INSERT INTO study_group VALUES (?, ?)",
                group.getId(), group.getName());
    }

    // Удаление группы
    public int deleteGroup(int id) {
        return jdbcTemplate.update("DELETE FROM study_group WHERE id = ?", id);
    }
}