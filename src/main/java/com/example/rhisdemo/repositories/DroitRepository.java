package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Droit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitRepository extends JpaRepository<Droit,Long> {
}
