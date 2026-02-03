package com.example.Supply_Management.controller;

import com.example.Supply_Management.model.Product;
import com.example.Supply_Management.repository.ProductRepository;
import com.example.Supply_Management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product.getName(), product.getType(), product.getVariety());
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getType")
    public List<Product> getProductsByType(@RequestBody Product product){
        return productService.getProductsByType(product.getType());
    }

    @GetMapping("/getName")
    public List<Product> searchProducts(@RequestBody Product product){
        return productService.searchProducts(product.getName());
    }
}
