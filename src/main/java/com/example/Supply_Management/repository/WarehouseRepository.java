package com.example.Supply_Management.repository;

import com.example.Supply_Management.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Optional<Warehouse> findByProductId(Long productId);

    @Query("SELECT w FROM Warehouse w WHERE w.receivedDate BETWEEN :startDate AND :endDate")
    List<Warehouse> findByReceivedDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate
    );
}