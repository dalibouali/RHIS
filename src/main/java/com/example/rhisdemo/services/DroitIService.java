package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Droit;

import java.util.List;

public interface DroitIService {


    //Droit Crud
    public List<Droit> droitdisplayAll();
    public Droit addDroit(Droit d, long role_id,long ecran_id);
    public Droit modifyDroit(Droit d, long role_id,long ecran_id);
    public Droit retrieveDroit(long id);
    public void deleteDroit(long id);

}
