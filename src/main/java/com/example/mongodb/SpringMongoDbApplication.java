package com.example.mongodb;

import com.example.mongodb.domain.Department;
import com.example.mongodb.domain.Person;
import com.example.mongodb.domain.Staff;
import com.example.mongodb.repo.DepartmentRepository;
import com.example.mongodb.repo.StaffRepository;
import org.bson.types.ObjectId;
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
public class SpringMongoDbApplication implements CommandLineRunner {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public SpringMongoDbApplication(StaffRepository staffRepository, DepartmentRepository departmentRepository) {
        this.staffRepository = staffRepository;
        this.departmentRepository = departmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        //Staff
        Staff deanJones = staffRepository.save(new Staff(ObjectId.get(), new Person("John", "Jones")));
        Staff deanMartin = staffRepository.save(new Staff(ObjectId.get(), new Person("Matthew", "Martin")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("James", "Brown")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Judy", "Miller")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("James", "Davis")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Allison", "Moore")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Tom", "Thomas")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Graham", "Green")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Whitney", "White")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Jack", "Black")));
        staffRepository.save(new Staff(ObjectId.get(), new Person("Queen", "King")));

        //Departments
        departmentRepository.save(new Department(ObjectId.get(), "Humanities", deanJones));
        departmentRepository.save(new Department(ObjectId.get(), "Natural Sciences", deanMartin));
        departmentRepository.save(new Department(ObjectId.get(), "Social Sciences", deanJones));
    }
}