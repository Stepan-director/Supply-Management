package com.example.Supply_Management.repository;

import com.example.Supply_Management.model.Delivery;
import com.example.Supply_Management.model.DeliveryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryProductRepository  extends JpaRepository<DeliveryProduct,Long> {

    Optional<DeliveryProduct> findByDeliveryAndProductId(Long deliveryId, Long productId);

}
