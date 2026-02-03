package com.example.Supply_Management.controller;


import com.example.Supply_Management.model.Supplier;
import com.example.Supply_Management.repository.SupplierRepository;
import com.example.Supply_Management.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @Autowired
    private SupplierRepository supplierRepository;

    @PostMapping("/create")
    public Supplier createSupplier(@RequestBody Supplier supplier){
        return service.createSupplier(supplier.getName(), supplier.getPhone());
    }

    @GetMapping("/getAll")
    public List<Supplier> getAllSuppliers(){
        return service.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier){
        return service.updateSupplier(supplier.getId(),supplier.getName(), supplier.getPhone());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable Long id){
        service.deleteSupplier(id);
    }


}
