package com.example.rhisdemo.services;

import com.example.rhisdemo.repositories.DroitRepository;
import com.example.rhisdemo.repositories.RoleRepository;
import com.example.rhisdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.file.attribute.UserPrincipal;

public class AuthorizationSE {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DroitRepository droitRepository;

    /**
     * Vérifie l'autorisation pour les privileges qui ne sont pas sensé contenir de contraintes sur l'objet visé
     * @param action le type d'action demandée
     * @param entity l'objet visé
     * @return
     */
  /*  public boolean can(String action, String entity) {
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //recuperation du privilege par action et par entité : logiquement il n'en existe qu'un par role avec cette action et cet objet
        Privilege privilege = privilegeRepo.findByActionAndEntityAndRole(action, entity, currentUser.getRole());
        //si privileges existe et qu'il n'attend pas de vérification de contrainte
        return (null != privilege && !privilege.isConstrained());

    }*/
}
