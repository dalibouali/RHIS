package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByName(String name);

}
