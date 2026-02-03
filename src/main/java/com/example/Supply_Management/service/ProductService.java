package com.example.Supply_Management.service;

import com.example.Supply_Management.model.Product;
import com.example.Supply_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String name, String type, String variety){
        Product product = new Product();

        product.setName(name);
        product.setType(type);
        product.setVariety(variety);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByType(String type){
        return productRepository.findByType(type);
    }

    public List<Product> searchProducts(String name){
        return productRepository.findByName(name);
    }
}
