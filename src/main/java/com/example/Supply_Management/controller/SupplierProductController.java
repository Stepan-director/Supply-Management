package com.example.Supply_Management.controller;

import com.example.Supply_Management.model.SupplierProduct;
import com.example.Supply_Management.repository.SupplierProductRepository;
import com.example.Supply_Management.service.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/supplierProduct")
public class SupplierProductController {

    @Autowired
    private SupplierProductService service;

    @Autowired
    private SupplierProductRepository repository;

    @PostMapping // +
    public SupplierProduct addProductToSupplier(@RequestBody SupplierProduct supplierProduct) {
        return service.addProductToSupplier(
                supplierProduct.getSupplierId(),
                supplierProduct.getProductId(),
                supplierProduct.getPrice()
        );
    }

    @GetMapping // +
    public List<SupplierProduct> getSupplierPrices() {
        return service.getSupplierPrices();
    }

    @GetMapping("/{productName}") // +
    public List<SupplierProduct> getProductSuppliers(@PathVariable String productName) {
        return service.getProductSuppliers(productName);
    }

    @PutMapping // +
    public SupplierProduct updatePrice(@RequestBody SupplierProduct supplierProduct) {
        return service.updatePrice(supplierProduct.getId(), supplierProduct.getPrice());
    }

}
