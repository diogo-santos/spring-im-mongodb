package com.example.mongodb.web;

import com.example.mongodb.domain.Department;
import com.example.mongodb.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private DepartmentRepository repo;

    @Autowired
    public DepartmentController(DepartmentRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = "/find", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Department findDepartmentByName(@RequestParam String name) {
        return repo.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Department> findAllDepartments() {
        return repo.findAll();
    }
}