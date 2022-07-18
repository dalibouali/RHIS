package com.example.rhisdemo.repositories;

import com.example.rhisdemo.entities.Product;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public  Product findByName(String name);
}
