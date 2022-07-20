package com.example.rhisdemo.services;

import com.example.rhisdemo.Dto.ProductRequest;
import com.example.rhisdemo.Dto.UserRequest;
import com.example.rhisdemo.entities.Product;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.repositories.ProductRepository;
import com.example.rhisdemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplementation implements ServiceInterface{
    private final  UserRepository userRepository;
    private final ProductRepository productRepository;

    public ServiceImplementation(UserRepository userRepository,ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository=productRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String  username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User updateUser(String username, UserRequest newuser) {
        User u=userRepository.findUserByUsername(username);
        if(u!=null){


        if (newuser.getUsername()!=null){
            u.setUsername(newuser.getUsername());
        }
        if (newuser.getFirstName()!=null){
            u.setFirstName(newuser.getFirstName());
        }
        if (newuser.getLastName()!=null){
            u.setLastName(newuser.getLastName());
        }
        }
        else{
            return null;
        }

        return userRepository.save(u);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(userRepository.findUserByUsername(username));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product updateProduct(Product p, ProductRequest newpro) {
        if (newpro.getName()!=null){
            p.setName(newpro.getName());
        }
        if (newpro.getPrice()!=0){
            p.setPrice(newpro.getPrice());
        }


        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(String username) {
        productRepository.delete(productRepository.findByName(username));

    }
}
