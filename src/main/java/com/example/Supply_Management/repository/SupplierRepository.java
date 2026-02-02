package com.example.Supply_Management.repository;

import com.example.Supply_Management.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

}
