package com.example.Supply_Management.controller;

import com.example.Supply_Management.model.SupplierProduct;
import com.example.Supply_Management.service.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController("/supplierProduct")
public class SupplierProductController {

    @Autowired
    private SupplierProductService service;

    @PostMapping
    public SupplierProduct addProductToSupplier(@RequestBody SupplierProduct supplierProduct) {
        return service.addProductToSupplier(
                supplierProduct.getSupplierId(),
                supplierProduct.getProductId(),
                supplierProduct.getPrice()
        );
    }

    @GetMapping
    public List<SupplierProduct> getSupplierPrices() {
        return service.getSupplierPrices();
    }

    @GetMapping("/supplierProduct/{name}")
    public List<SupplierProduct> getProductSuppliers(String name) {
        return service.getSupplierPrices();
    }

    @PutMapping
    public SupplierProduct updatePrice(@RequestBody SupplierProduct supplierProduct) {
        return service.updatePrice(supplierProduct.getId(), supplierProduct.getPrice());
    }
}
