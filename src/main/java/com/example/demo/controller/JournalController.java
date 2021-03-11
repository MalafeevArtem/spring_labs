package com.example.demo.controller;

import com.example.demo.dao.JournalJdbc;
import com.example.demo.model.Group;
import com.example.demo.model.Journal;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {

    private final JournalJdbc journalJdbc;

    public JournalController(JournalJdbc journalJdbc) {
        this.journalJdbc = journalJdbc;
    }

    @CrossOrigin
    @GetMapping("/journals")
    public List<Journal> getJournals() {
        return journalJdbc.getAllJournal();
    }

    // Просмотр журнала
    @CrossOrigin
    @GetMapping("/journal/{id}")
    public Journal getJournal(@PathVariable int id) {
        Journal journal = journalJdbc.getJournal(id);

        return journal;
    }

    // Создание журнала
    @CrossOrigin
    @PostMapping("/journal")
    public int addJournal(@RequestBody Journal journal) {
        return journalJdbc.createJournal(journal);
    }

    // Просмотр журнала у группы
    @CrossOrigin
    @GetMapping("/journal/group/{id}")
    public List<Journal> getJournalGroup(@PathVariable int id) {

        return journalJdbc.getJournalByGroup(id);
    }

    // Просмотр журнала у студента
    @CrossOrigin
    @GetMapping("/journal/student/{id}")
    public List<Journal> getJournalStudent(@PathVariable int id) {

        return journalJdbc.getJournalByStudent(id);
    }

    @CrossOrigin
    @PatchMapping("/journal/{id}")
    public int updateGroup(@PathVariable int id, @RequestBody Journal journal) {
        return journalJdbc.updateJournal(id, journal);
    }
}
