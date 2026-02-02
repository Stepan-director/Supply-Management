package com.example.Supply_Management.controller;


import com.example.Supply_Management.model.Supplier;
import com.example.Supply_Management.repository.SupplierRepository;
import com.example.Supply_Management.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService service;

    @Autowired
    private SupplierRepository supplierRepository;



}
