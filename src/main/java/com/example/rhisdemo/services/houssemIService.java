package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.entities.Role;

import java.util.List;

// Service interface Added by houssem containing crud methods of the following classes:
// Affectation, Ecran, Role,Droit
public interface houssemIService {


    // Role Crud
    public List<Role> roledisplayAll();
    public Role addRole(Role r);
    public Role modifiyRole(Role r);
    public void deleteRole(long r);

    public Role getRoleByname(String name);

    // Affectation Crud
    public List<Affectation> affectationdisplayAll();
    public Affectation addAffectation(Affectation a, long role_id,long user_id);
    public Affectation modifyAffectation(Affectation a,long role_id,long user_id);
    public void deleteAffectation(long id);


    //Ecran Crud
    public List<Ecran> ecrandisplayAll();
    public Ecran addEcran(Ecran e);
    public Ecran modifyEcran(Ecran e);
    public Ecran retrieveEcran(long id);
    public void deleteEcran(long id);
    public Ecran getEcran(String name);



    //Droit Crud
    public List<Droit> droitdisplayAll();
    public Droit addDroit(Droit d, long role_id,long ecran_id);
    public Droit modifyDroit(Droit d, long role_id,long ecran_id);
    public Droit retrieveDroit(long id);
    public void deleteDroit(long id);

}
