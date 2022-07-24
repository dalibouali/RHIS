package com.example.rhisdemo.services;

import com.example.rhisdemo.Dto.ProductRequest;
import com.example.rhisdemo.Dto.UserRequest;
import com.example.rhisdemo.entities.Product;
import com.example.rhisdemo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    public UserDetails loadUserByUsername(String username);


    public List<User> getAllUsers();
    public User getUser(String username);
    public User addUser(User u);
    public User updateUser(String username, UserRequest newuser);
    public void deleteUser(String username);


    public List<Product> getAllProducts();
    public Product getProduct(String name);
    public Product addProduct(Product p);
    public Product updateProduct(String name, ProductRequest newpro);
    public void deleteProduct(String username);



}
