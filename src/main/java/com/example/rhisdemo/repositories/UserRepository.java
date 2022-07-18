package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
}
