package com.example.mongodb;

import com.example.mongodb.domain.Department;
import com.example.mongodb.domain.Person;
import com.example.mongodb.domain.Staff;
import com.example.mongodb.repo.DepartmentRepository;
import com.example.mongodb.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Main Spring Boot Class for the demo MongoDb Application.
 * On Startup Initialize Database with Staff and Departments.
 *
 */
@SpringBootApplication
@Import(InMemoryMongoConfig.class)
public class MongoDbApplication implements CommandLineRunner {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public MongoDbApplication(StaffRepository staffRepository, DepartmentRepository departmentRepository) {
        this.staffRepository = staffRepository;
        this.departmentRepository = departmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        //Staff
        Staff deanJones = staffRepository.save(new Staff(1, new Person("John", "Jones")));
        Staff deanMartin = staffRepository.save(new Staff(2, new Person("Matthew", "Martin")));
        staffRepository.save(new Staff(3, new Person("James", "Brown")));
        staffRepository.save(new Staff(4, new Person("Judy", "Miller")));
        staffRepository.save(new Staff(5, new Person("James", "Davis")));
        staffRepository.save(new Staff(6, new Person("Allison", "Moore")));
        staffRepository.save(new Staff(7, new Person("Tom", "Thomas")));
        staffRepository.save(new Staff(8, new Person("Graham", "Green")));
        staffRepository.save(new Staff(9, new Person("Whitney", "White")));
        staffRepository.save(new Staff(10, new Person("Jack", "Black")));
        staffRepository.save(new Staff(11, new Person("Queen", "King")));

        //Departments
        departmentRepository.save(new Department(100, "Humanities", deanJones));
        departmentRepository.save(new Department(200, "Natural Sciences", deanMartin));
        departmentRepository.save(new Department(300, "Social Sciences", deanJones));
    }
}