package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Ecran;

import java.util.List;

public interface EcranIService {


    //Ecran Crud
    public List<Ecran> ecrandisplayAll();
    public Ecran addEcran(Ecran e);
    public Ecran modifyEcran(Ecran e);
    public Ecran retrieveEcran(long id);
    public void deleteEcran(long id);
    public Ecran getEcran(String name);
}
