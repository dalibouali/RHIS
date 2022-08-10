package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.repositories.AffectationRepository;
import com.example.rhisdemo.repositories.RoleRepository;
import com.example.rhisdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationService implements AffectationIService{


    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Affectation> affectationdisplayAll() {
        return (List<Affectation>) affectationRepository.findAll();
    }

    @Override
    public Affectation addAffectation(Affectation a, long role_id, long user_id) {
        Role r= roleRepository.findById(role_id).get();
        User u= userRepository.findById(user_id).get();
        a.setUser(u);
        a.setRole(r);

        return affectationRepository.save(a);

    }

    @Override
    public Affectation modifyAffectation(Affectation a, long role_id, long user_id) {
        Role r= roleRepository.findById(role_id).orElse(null);
        User u= userRepository.findById(user_id).orElse(null);
        a.setUser(u);
        a.setRole(r);
        return affectationRepository.save(a);
    }

    @Override
    public void deleteAffectation(long id) {

        affectationRepository.deleteById(id);
    }

}
