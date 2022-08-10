package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService  implements RoleIService{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> roledisplayAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role addRole(Role r) {
        return roleRepository.save(r);
    }

    @Override
    public Role modifiyRole(Role r) {
        return roleRepository.save(r);
    }

    @Override
    public void deleteRole(long r) {

        roleRepository.deleteById(r);
    }


    @Override
    public Role getRoleByname(String name) {
        return roleRepository.findByName(name);
    }


}
