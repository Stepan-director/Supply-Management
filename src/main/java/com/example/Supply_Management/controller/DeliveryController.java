package com.example.Supply_Management.controller;


import com.example.Supply_Management.model.Delivery;
import com.example.Supply_Management.model.DeliveryProduct;
import com.example.Supply_Management.model.SupplierProduct;
import com.example.Supply_Management.repository.DeliveryRepository;
import com.example.Supply_Management.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;


    @PostMapping // +
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery.getSupplierId());
    }

    @PostMapping("/{id}/confirm") // +
    public Delivery confirmDelivery(@PathVariable Long id) {
        return deliveryService.confirmDelivery(id);
    }

    @PostMapping("/{id}/cancel")
    public Delivery cancelDelivery(@PathVariable Long id) {
        return deliveryService.cancelDelivery(id);
    }

    @DeleteMapping("/{id}") // +
    public void deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
    }

    @PostMapping("/{deliveryId}/items")
    public DeliveryProduct addProductDelivery(
            @PathVariable Long deliveryId, @RequestBody Map<String, Object> request) {

        Long productId = Long.valueOf(request.get("productId").toString());
        Double quantity = Double.valueOf(request.get("quantity").toString());

        return deliveryService.addProductDelivery(deliveryId, productId, quantity);
    }

    @PostMapping("/{deliveryId}/accept")
    public void acceptDelivery(@PathVariable Long deliveryId) {
        deliveryService.acceptedDelivery(deliveryId);
    }
}
