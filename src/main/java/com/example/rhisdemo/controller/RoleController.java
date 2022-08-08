package com.example.rhisdemo.controller;


import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.services.RoleIService;
import com.example.rhisdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class RoleController {

   @Autowired
   RoleIService RoleService;

    // ROLES HTTP METHODS
    @GetMapping("/retrieve-all-roles")
    public List<Role> retriveroles(){
        return RoleService.roledisplayAll();
    }
    @PostMapping("/add-role")
    public Role addrole(@RequestBody Role role){
        return RoleService.addRole(role);
    }
    @PutMapping("/modify-role")
    public Role modifyRole(@RequestBody Role role){
        return RoleService.modifiyRole(role);
    }
    @DeleteMapping("/delete-role/{id}")
    public void deleterole(@PathVariable("id") long id){
        RoleService.deleteRole(id);
    }
    @GetMapping("/retrieve-role/{name}")
    public Role findRoleByName(@PathVariable("name") String name){
        return RoleService.getRoleByname(name);
    }





}
