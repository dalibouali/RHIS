package com.example.rhisdemo.services;

import com.example.rhisdemo.entities.Role;

import java.util.List;

public interface RoleIService {


    // Role Crud
    public List<Role> roledisplayAll();

    public Role addRole(Role r);

    public Role modifiyRole(Role r);

    public void deleteRole(long r);

    public Role getRoleByname(String name);
}
