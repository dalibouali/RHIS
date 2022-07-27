package com.example.rhisdemo.repositories;


import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// affectation repository added by houssem
@Repository
public interface AffectationRepository extends CrudRepository<Affectation,Long> {
    @Query("select a from Affectation a where a.user.id=:user_id")
    public List<Affectation> findByUser(@Param("user_id")Long user_id);
}
