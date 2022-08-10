package com.example.rhisdemo.controller;

import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.services.AffectationIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class AffectationController {

    @Autowired
    AffectationIService AffectationService;


    // AFFECTATION HTTP METHODS
    @GetMapping("/retireve-all-affectation")
    public List<Affectation> getAllAffectation(){
        return AffectationService.affectationdisplayAll();
    }
    @PutMapping("/modify-affectation/{role_id}/{user_id}")
    public Affectation modifyAffectation(@PathVariable("role_id") long role_id,@RequestBody Affectation a,@PathVariable("user_id") long user_id){
        return AffectationService.modifyAffectation(a,role_id,user_id);

    }

    @PostMapping("/add-affectation/{role_id}/{user_id}")
    public Affectation addAffectation(@PathVariable("role_id") long role_id,@RequestBody Affectation a,@PathVariable("user_id") long user_id){
        return AffectationService.addAffectation(a,role_id,user_id);

    }

    @DeleteMapping("/delete-affectation/{id}")
    public void deleteAffectation(@PathVariable("id") long id){
        AffectationService.deleteAffectation(id);
    }



}
