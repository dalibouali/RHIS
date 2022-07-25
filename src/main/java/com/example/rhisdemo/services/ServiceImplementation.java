package com.example.rhisdemo.services;

import com.example.rhisdemo.Dto.ProductRequest;
import com.example.rhisdemo.Dto.UserRequest;
import com.example.rhisdemo.entities.Product;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.repositories.ProductRepository;
import com.example.rhisdemo.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j //for log
public class ServiceImplementation implements ServiceInterface, UserDetailsService {
    private final  UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    public ServiceImplementation(UserRepository userRepository, ProductRepository productRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository=productRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUsername(username);
        if(user==null)
        {
            log.error("User not found in DB");
            throw new UsernameNotFoundException("USEr not found in the database");
        }else{
            log.info("User found in DB :{}",username);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
       /* user.getAffectationList().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
        });*/
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities) ;
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

        u.setPassword(passwordEncoder.encode(u.getPassword()));
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
    public Product updateProduct(String name, ProductRequest newpro) {
        Product p=productRepository.findByName(name);
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
