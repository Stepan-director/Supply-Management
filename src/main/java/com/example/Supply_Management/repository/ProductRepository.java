package com.example.Supply_Management.repository;

import com.example.Supply_Management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByType(String type);
    List<Product> findByName(String name);
}
