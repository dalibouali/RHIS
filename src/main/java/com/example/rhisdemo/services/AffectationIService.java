package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Affectation;

import java.util.List;

public interface AffectationIService {
    // Affectation Crud
    public List<Affectation> affectationdisplayAll();
    public Affectation addAffectation(Affectation a, long role_id,long user_id);
    public Affectation modifyAffectation(Affectation a,long role_id,long user_id);
    public void deleteAffectation(long id);

}
