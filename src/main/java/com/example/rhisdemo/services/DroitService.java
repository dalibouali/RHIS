package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.repositories.DroitRepository;
import com.example.rhisdemo.repositories.EcranRepository;
import com.example.rhisdemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroitService implements DroitIService{


    @Autowired
    private EcranRepository ecranRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DroitRepository droitRepository;

    @Override
    public List<Droit> droitdisplayAll() {
        return (List<Droit>) droitRepository.findAll();
    }

    @Override
    public Droit addDroit(Droit d, long role_id, long ecran_id) {
        Role r= roleRepository.findById(role_id).orElse(null);
        Ecran e= ecranRepository.findById(ecran_id).orElse(null);
        d.setEcran(e);
        d.setRole(r);
        return droitRepository.save(d);
    }

    @Override
    public Droit modifyDroit(Droit d, long role_id, long ecran_id) {
        Role r= roleRepository.findById(role_id).orElse(null);
        Ecran e= ecranRepository.findById(ecran_id).orElse(null);
        d.setEcran(e);
        d.setRole(r);
        return droitRepository.save(d);
    }

    @Override
    public Droit retrieveDroit(long id) {
        return droitRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDroit(long id) {

        droitRepository.deleteById(id);
    }
}
