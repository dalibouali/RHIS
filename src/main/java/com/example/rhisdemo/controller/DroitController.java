package com.example.rhisdemo.controller;

import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.services.DroitIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class DroitController {


    @Autowired
    DroitIService DroitService;



    // DROIT HTTP METHODS
    @GetMapping("/retrieve-all-droits")
    public List<Droit> getAllDroits(){
        return DroitService.droitdisplayAll();
    }

    @PostMapping("/add-droit/{role_id}/{ecran_id}")
    public Droit addDroit(@PathVariable("role_id") long role_id,@PathVariable("ecran_id") long ecran_id,@RequestBody Droit droit)
    {
        return DroitService.addDroit(droit,role_id,ecran_id);
    }
    @PutMapping("/modify-droit/{role_id}/{ecran_id}")
    public Droit modifyDroit(@PathVariable("role_id") long role_id,@PathVariable("ecran_id") long ecran_id,@RequestBody Droit droit)
    {
        return DroitService.modifyDroit(droit,role_id,ecran_id);
    }

    @GetMapping("/retrieve-droit/{id}")
    public Droit retrieveDroit(@PathVariable("id") long id){
        return DroitService.retrieveDroit(id);
    }
    @DeleteMapping("/delete-droit/{id}")
    public void deleteDroit(@PathVariable("id")long id){
        DroitService.deleteDroit(id);
    }
}
