package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.repositories.EcranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcranService implements EcranIService{

    @Autowired
    private EcranRepository ecranRepository;

    @Override
    public List<Ecran> ecrandisplayAll() {
        return (List<Ecran>) ecranRepository.findAll();
    }

    @Override
    public Ecran addEcran(Ecran e) {
        return ecranRepository.save(e);
    }

    @Override
    public Ecran modifyEcran(Ecran e) {
        return ecranRepository.save(e);
    }

    @Override
    public Ecran retrieveEcran(long id) {
        return ecranRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEcran(long id) {

        ecranRepository.deleteById(id);
    }

    @Override
    public Ecran getEcran(String name) {
        return ecranRepository.findByName(name);
    }

}
