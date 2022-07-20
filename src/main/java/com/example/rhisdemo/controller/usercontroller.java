package com.example.rhisdemo.controller;

import com.example.rhisdemo.Dto.ProductRequest;
import com.example.rhisdemo.Dto.UserRequest;
import com.example.rhisdemo.entities.Product;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.services.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class usercontroller {


    private final ServiceInterface serviceInterface;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(serviceInterface.getAllUsers());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> showUserDetails(@PathVariable String username){

        User user =serviceInterface.getUser(username);
        if(user!=null)
            return  ResponseEntity.ok().body(user);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");



    }
    @PostMapping("/adduser")
    public  ResponseEntity<?> adduser(@RequestBody User user){
        serviceInterface.addUser(user);
        return  ResponseEntity.ok().body(user);
    }

    @PutMapping("/updateuser/{username}")
        public  ResponseEntity<?> adduser(@PathVariable String username,@RequestBody UserRequest user){
            serviceInterface.updateUser(username,user);
            return  ResponseEntity.ok().body(user);
        }

   @DeleteMapping("/delete/{username}")
   public  ResponseEntity<?> deleteuser(@PathVariable String username){
        serviceInterface.deleteUser(username);
        return ResponseEntity.ok().body("user deleted successfully ");
   }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProduct() {
        return ResponseEntity.ok().body(serviceInterface.getAllProducts());
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<?> showProductDetails(@PathVariable String name){

        Product prod =serviceInterface.getProduct(name);
        if(prod!=null)
            return  ResponseEntity.ok().body(prod);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");



    }

    @PostMapping("/addproduct")
    public  ResponseEntity<?> addProduct(@RequestBody Product prod){
        serviceInterface.addProduct(prod);
        return  ResponseEntity.ok().body(prod);
    }

    @DeleteMapping("/deleteproduct/{name}")
    public  ResponseEntity<?> deleteproduct(@PathVariable String name){
        serviceInterface.deleteProduct(name);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/updateproduct/{name}")
    public  ResponseEntity<?> updateproduct(@PathVariable String name,@RequestBody ProductRequest product){
        serviceInterface.updateProduct(name,product);
        return  ResponseEntity.ok().body(product);
    }


}
