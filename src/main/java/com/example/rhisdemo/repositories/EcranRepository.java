package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// ecran repository added by houssem
@Repository
public interface EcranRepository  extends JpaRepository<Ecran,Long> {
    public Ecran findByName(String name);
}
