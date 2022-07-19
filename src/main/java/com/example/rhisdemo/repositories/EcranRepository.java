package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Ecran;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// ecran repository added by houssem
@Repository
public interface EcranRepository  extends CrudRepository<Ecran,Long> {
}
