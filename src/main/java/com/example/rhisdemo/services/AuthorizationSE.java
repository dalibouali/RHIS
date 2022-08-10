package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.repositories.AffectationRepository;
import com.example.rhisdemo.repositories.DroitRepository;
import com.example.rhisdemo.repositories.RoleRepository;
import com.example.rhisdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.*;


@Service
public class AuthorizationSE {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AffectationRepository affectationRepository;
    @Autowired
    private DroitRepository droitRepository;

    public AuthorizationSE(UserRepository userRepository, AffectationRepository affectationRepository, DroitRepository droitRepository) {
        this.userRepository = userRepository;
        this.affectationRepository = affectationRepository;
        this.droitRepository = droitRepository;
    }


    public Map<String, Object> getPrivileges(String username) {
        System.out.println(username);


        Map<String, Object> privileges = new HashMap<>();
        User user = userRepository.findUserByUsername(username);
        List<Affectation> affectations = affectationRepository.findByUser(user.getId());
        for (Affectation a : affectations) {
            List<Droit> droits = droitRepository.findAllByRole(a.getRole().getId());
            for (Droit d : droits) {

                privileges.put(d.getEcran().getName(), d.getCum());
            }

        }
        return privileges;
    }
}