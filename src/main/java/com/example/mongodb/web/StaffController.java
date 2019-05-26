package com.example.mongodb.web;

import com.example.mongodb.domain.Person;
import com.example.mongodb.domain.Staff;
import com.example.mongodb.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/staff")
public class StaffController {
    private StaffRepository repo;

    @Autowired
    public StaffController(StaffRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = "/find", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Staff> findMemberByName(@RequestBody Person person) {
        List<Staff> members = new ArrayList<>();
        if (person.getFirstName() != null && !person.getFirstName().trim().isEmpty()) {
            members = repo.findByFirstName(person.getFirstName());
        } else if (person.getLastName() != null && !person.getLastName().trim().isEmpty()) {
            members = repo.findByMemberLastName(person.getLastName());
        }
        return members;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Staff> findAllMembers() {
        return repo.findAll();
    }
}