package com.example.mongodb.repo;

import com.example.mongodb.domain.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    Department findByName(String name);
    @Query("{ 'name' : { $regex: ?0 } }")
    List<Department> findNameByPattern(String pattern);
}
