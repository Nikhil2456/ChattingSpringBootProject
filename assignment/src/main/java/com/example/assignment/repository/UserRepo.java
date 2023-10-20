package com.example.assignment.repository;

import com.example.assignment.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    User findByName(String name);
}
