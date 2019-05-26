package com.example.mongodb.repo;

import com.example.mongodb.MongoDbApplication;
import com.example.mongodb.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * DepartmentRepositoryTest.
 *
 * Departments persisted to Fongo in-Memory database at startup.
 * @see MongoDbApplication
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {
	@Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void findAllWhenSortAscByNameTest() {
        System.out.println("\nFind all Departments, sort alphabetically by name");
        List<Department> departments = departmentRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
        departments.forEach(System.out::println);
        assertThat(departments).extracting(Department::getName).first().isEqualTo("Humanities");
    }

    @Test
    public void givenExactNameThenFindByNameTest() {
        System.out.println("\nFind Department with the exact name 'Natural Sciences' \n");
        Department department = departmentRepository.findByName("Natural Sciences");
        assertThat(department).isNotNull();
        assertThat(department.getName()).isEqualTo("Natural Sciences");
    }

    @Test
    public void givenNameEndingThenFindByPatternTest() {
        //@Query with JSON query string that accepts regular expression as a parameter
        System.out.println("\nFind all Departments with name ending in Sciences");
        List<Department> departments = departmentRepository.findNameByPattern(".[Ss]ciences");
        departments.forEach(System.out::println);
        assertThat(departments).extracting(Department::getName).contains("Natural Sciences", "Social Sciences");
    }
}