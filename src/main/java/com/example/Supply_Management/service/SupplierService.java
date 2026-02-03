package com.example.Supply_Management.service;


import com.example.Supply_Management.model.Supplier;
import com.example.Supply_Management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(String name, String phone){
        Supplier supplier = new Supplier();

        supplier.setName(name);
        supplier.setPhone(phone);

        return  supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id){
        return supplierRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Не найден поставщик с ID: " + id));
    }

    public Supplier updateSupplier(Long id, String name, String phone){
        Supplier supplier = supplierRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Не удалось найти поставщика с данным ID " + id));

        supplier.setName(name);
        supplier.setPhone(phone);

        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id){
        Supplier supplier = supplierRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Не удалось найти поставщика с данным ID " + id));

        supplierRepository.delete(supplier);
    }

}
