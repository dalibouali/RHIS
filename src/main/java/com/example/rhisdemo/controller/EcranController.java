package com.example.rhisdemo.controller;

import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.services.EcranIService;
import com.example.rhisdemo.services.EcranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class EcranController {

    @Autowired
    EcranIService EcranService;


    // ECRAN HTTP METHODS
    @GetMapping("/get-all-ecran")
    public List<Ecran> getAllEcran(){
        return EcranService.ecrandisplayAll();
    }

    @PutMapping("/modify-ecran")
    public Ecran modifyEcran(@RequestBody Ecran e){
        return  EcranService.modifyEcran(e);
    }

    @PostMapping("/add-ecran")
    public Ecran addEcran(@RequestBody Ecran e){
        return EcranService.addEcran(e);
    }
    @GetMapping("/retrieve-ecran/{id}")
    public Ecran retiriveEcranById(@PathVariable("id") long id){

        return EcranService.retrieveEcran(id);
    }

    @DeleteMapping("/delete-ecran/{id}")
    public void deleteEcran(@PathVariable("id")long id){
        EcranService.deleteEcran(id);
    }

    @GetMapping("/get-ecran/{name}")
    public Ecran getEcran(@PathVariable("name") String name){return EcranService.getEcran(name);}

}
