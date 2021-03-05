package com.example.demo.controller;

import com.example.demo.dao.GroupJdbc;
import com.example.demo.dao.MarkJdbc;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    private final GroupJdbc groupJdbc;

    public GroupController(GroupJdbc groupJdbc) {
        this.groupJdbc = groupJdbc;
    }

    // Просмотр группы
    @GetMapping("/group/{id}")
    public Group getGroup(@PathVariable int id) {
        Group group = groupJdbc.get(id);

        return group;
    }

    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupJdbc.getAll();
    }

    @PutMapping("/group/{id}")
    public int updateGroup(@PathVariable int id, @RequestBody Group group) {
        return groupJdbc.updateGroup(id, group);
    }

    @PostMapping("/group_create")
    public int AddGroup(@RequestBody Group group) {
        return groupJdbc.createGroup(group);
    }

    @DeleteMapping("/group/{id}")
    public int deleteGroup(@PathVariable int id) {
        return groupJdbc.deleteGroup(id);
    }
}
