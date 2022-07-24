package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.*;
import com.example.rhisdemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// Service class Added by houssem containing crud methods of the following classes:
// Affectation, Ecran, Role,Droit
@Service
public class houssemService implements houssemIService {


    @Autowired
    private UserRepository ur;

    @Autowired
    private RoleRepository rr;

    @Autowired
    private AffectationRepository ar;

    @Autowired
    private EcranRepository er;

    @Autowired
    private DroitRepository dr;

    @Override
    public List<Role> roledisplayAll() {
        return (List<Role>) rr.findAll();
    }

    @Override
    public Role addRole(Role r) {
        return rr.save(r);
    }

    @Override
    public Role modifiyRole(Role r) {
        return rr.save(r);
    }

    @Override
    public void deleteRole(long r) {

        rr.deleteById(r);
    }


    @Override
    public Role getRoleByname(String name) {
       return rr.findByName(name);
    }



    @Override
    public List<Affectation> affectationdisplayAll() {
        return (List<Affectation>) ar.findAll();
    }

    @Override
    public Affectation addAffectation(Affectation a, long role_id, long user_id) {
        Role r=rr.findById(role_id).get();
        User u=ur.findById(user_id).get();

        // ODT

        a.setUser(u);
        a.setRole(r);

        return ar.save(a);

    }

    @Override
    public Affectation modifyAffectation(Affectation a, long role_id, long user_id) {
        Role r=rr.findById(role_id).orElse(null);
        User u=ur.findById(user_id).orElse(null);
        a.setUser(u);
        a.setRole(r);

        return ar.save(a);
    }

    @Override
    public void deleteAffectation(long id) {

        ar.deleteById(id);
    }

    @Override
    public List<Ecran> ecrandisplayAll() {
        return (List<Ecran>) er.findAll();
    }

    @Override
    public Ecran addEcran(Ecran e) {
        return er.save(e);
    }

    @Override
    public Ecran modifyEcran(Ecran e) {
        return er.save(e);
    }

    @Override
    public Ecran retrieveEcran(long id) {
        return er.findById(id).orElse(null);
    }

    @Override
    public void deleteEcran(long id) {

        er.deleteById(id);
    }

    @Override
    public List<Droit> droitdisplayAll() {
        return (List<Droit>) dr.findAll();
    }

    @Override
    public Droit addDroit(Droit d, long role_id, long ecran_id) {
        Role r=rr.findById(role_id).orElse(null);
        Ecran e=er.findById(ecran_id).orElse(null);
        d.setEcran(e);
        d.setRoleD(r);
        return dr.save(d);
    }

    @Override
    public Droit modifyDroit(Droit d, long role_id, long ecran_id) {
        Role r=rr.findById(role_id).orElse(null);
        Ecran e=er.findById(ecran_id).orElse(null);
        d.setEcran(e);
        d.setRoleD(r);
        return dr.save(d);
    }

    @Override
    public Droit retrieveDroit(long id) {
        return dr.findById(id).orElse(null);
    }

    @Override
    public void deleteDroit(long id) {

        dr.deleteById(id);
    }
}
