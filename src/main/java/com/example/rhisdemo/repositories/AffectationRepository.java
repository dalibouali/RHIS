package com.example.rhisdemo.repositories;


import com.example.rhisdemo.entities.Affectation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// affectation repository added by houssem
@Repository
public interface AffectationRepository extends CrudRepository<Affectation,Long> {
}
