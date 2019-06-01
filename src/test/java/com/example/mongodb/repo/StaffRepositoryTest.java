package com.example.mongodb.repo;

import com.example.mongodb.SpringMongoDbApplication;
import com.example.mongodb.domain.Person;
import com.example.mongodb.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StaffRepositoryTest.
 *
 * Staffs persisted to Fongo in-Memory database at startup.
 * @see SpringMongoDbApplication
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffRepositoryTest {
    @Autowired
    private StaffRepository repo;

    @Test
    public void findAllWhenSortAscByLastNameTest() {
        System.out.println("\nFind all staff members, sort alphabetically by last name");
        Iterable<Staff> members = repo.findAll(new Sort(Sort.Direction.ASC, "member.lastName"));
        members.forEach(System.out::println);
        assertThat(members).extracting(Staff::getMember).first().isEqualTo(new Person("Jack", "Black"));
    }

    @Test
    public void givenPageSizeThenReturnMembersAndSortAscByLastNameTest() {
        System.out.println("\nFind first 5 Staff members, sort alphabetically by last name");
        Page<Staff> members = repo.findAll(new PageRequest(0, 5, new Sort(Sort.Direction.ASC, "member.lastName")));
        members.forEach(System.out::println);
        assertThat(members).hasSize(5);
        assertThat(members).extracting(Staff::getMember).last().isEqualTo(new Person("John", "Jones"));
    }

    @Test
    public void givenNameThenFindByFirstNameTest() {
        //@Query with JSON query string
        System.out.println("\nFind all staff members with first name Queen");
        List<Staff> members = repo.findByFirstName("Queen");
        members.forEach(System.out::println);
        assertThat(members).extracting(Staff::getMember).contains(new Person("Queen", "King"));
    }

    @Test
    public void givenNameThenFindByMemberLastNameTest() {
        System.out.println("\nFind all staff members with last name Brown");
        List<Staff> members = repo.findByMemberLastName("Brown");
        members.forEach(System.out::println);
        assertThat(members).extracting(Staff::getMember).contains(new Person("James", "Brown"));
    }
}