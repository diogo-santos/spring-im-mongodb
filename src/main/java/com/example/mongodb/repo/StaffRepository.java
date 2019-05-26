package com.example.mongodb.repo;

import com.example.mongodb.domain.Staff;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Integer> {
    List<Staff> findByMemberLastName(String lastName);
    @Query("{ 'member.firstName' : ?0 }")
    List<Staff> findByFirstName(String firstName);
}