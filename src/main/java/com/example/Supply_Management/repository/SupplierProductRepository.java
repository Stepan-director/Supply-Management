package com.example.Supply_Management.repository;

import com.example.Supply_Management.model.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierProductRepository extends JpaRepository<SupplierProduct,Long> {

    List<SupplierProduct> findByProductName(String productName);

    Optional<SupplierProduct> findBySupplierAndProductId(Long supplierId, Long productId);

}
