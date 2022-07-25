package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroitRepository extends JpaRepository<Droit,Long> {
    public Droit findByRole(Role role);
    @Query("select d from Droit d where d.role.id=:role_id")
    public List<Droit> findAllByRole(@Param("role_id")Long role_id);
}
