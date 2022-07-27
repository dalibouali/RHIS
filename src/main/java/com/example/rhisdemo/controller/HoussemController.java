package com.example.rhisdemo.controller;


import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.Ecran;
import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.services.houssemIService;
import com.example.rhisdemo.services.houssemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller added by houssem to implement services in the houssemService class
@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class HoussemController {

    @Autowired
    houssemIService hs;


    // ROLES HTTP METHODS
    @GetMapping("/retrieve-all-roles")
    public List<Role> retriveroles(){
        return hs.roledisplayAll();
    }
    @PostMapping("/add-role")
    public Role addrole(@RequestBody Role role){
        return hs.addRole(role);
    }
    @PutMapping("/modify-role")
    public Role modifyRole(@RequestBody Role role){
        return hs.modifiyRole(role);
    }
    @DeleteMapping("/delete-role/{id}")
    public void deleterole(@PathVariable("id") long id){
        hs.deleteRole(id);
    }



    @GetMapping("/retrieve-role/{name}")
    public Role findRoleByName(@PathVariable("name") String name){
        return hs.getRoleByname(name);
    }







    // AFFECTATION HTTP METHODS
    @GetMapping("/retireve-all-affectation")
    public List<Affectation> getAllAffectation(){
        return hs.affectationdisplayAll();
    }
    @PutMapping("/modify-affectation/{role_id}/{user_id}")
    public Affectation modifyAffectation(@PathVariable("role_id") long role_id,@RequestBody Affectation a,@PathVariable("user_id") long user_id){
        return hs.modifyAffectation(a,role_id,user_id);

    }

    @PostMapping("/add-affectation/{role_id}/{user_id}")
    public Affectation addAffectation(@PathVariable("role_id") long role_id,@RequestBody Affectation a,@PathVariable("user_id") long user_id){
        return hs.addAffectation(a,role_id,user_id);

    }

    @DeleteMapping("/delete-affectation/{id}")
    public void deleteAffectation(@PathVariable("id") long id){
        hs.deleteAffectation(id);
    }


    // ECRAN HTTP METHODS
    @GetMapping("/get-all-ecran")
    public List<Ecran> getAllEcran(){
        return hs.ecrandisplayAll();
    }

    @PutMapping("/modify-ecran")
    public Ecran modifyEcran(@RequestBody Ecran e){
        return  hs.modifyEcran(e);
    }

    @PostMapping("/add-ecran")
    public Ecran addEcran(@RequestBody Ecran e){
        return hs.addEcran(e);
    }
    @GetMapping("/retrieve-ecran/{id}")
    public Ecran retiriveEcranById(@PathVariable("id") long id){

        return hs.retrieveEcran(id);
    }

    @DeleteMapping("/delete-ecran/{id}")
    public void deleteEcran(@PathVariable("id")long id){
        hs.deleteEcran(id);
    }

    @GetMapping("/get-ecran/{name}")
    public Ecran getEcran(@PathVariable("name") String name){return hs.getEcran(name);}

    // DROIT HTTP METHODS
    @GetMapping("/retrieve-all-droits")
    public List<Droit> getAllDroits(){
        return hs.droitdisplayAll();
    }

    @PostMapping("/add-droit/{role_id}/{ecran_id}")
    public Droit addDroit(@PathVariable("role_id") long role_id,@PathVariable("ecran_id") long ecran_id,@RequestBody Droit droit)
    {
        return hs.addDroit(droit,role_id,ecran_id);
    }
    @PutMapping("/modify-droit/{role_id}/{ecran_id}")
    public Droit modifyDroit(@PathVariable("role_id") long role_id,@PathVariable("ecran_id") long ecran_id,@RequestBody Droit droit)
    {
        return hs.modifyDroit(droit,role_id,ecran_id);
    }

    @GetMapping("/retrieve-droit/{id}")
    public Droit retrieveDroit(@PathVariable("id") long id){
        return hs.retrieveDroit(id);
    }
    @DeleteMapping("/delete-droit/{id}")
    public void deleteDroit(@PathVariable("id")long id){
        hs.deleteDroit(id);
    }
}
