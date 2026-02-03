package com.example.Supply_Management.controller;


import com.example.Supply_Management.model.Delivery;
import com.example.Supply_Management.model.DeliveryProduct;
import com.example.Supply_Management.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery.getSupplierId());
    }

    @PostMapping("/{id}/confirm")
    public Delivery confirmDelivery(@PathVariable Long id) {
        return deliveryService.confirmDelivery(id);
    }

    @PostMapping("/{id}/cancel")
    public Delivery cancelDelivery(@PathVariable Long id) {
        return deliveryService.cancelDelivery(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
    }

    @PostMapping("/{deliveryId}/items")
    public DeliveryProduct addProductDelivery(
            @PathVariable Long deliveryId,
            @RequestBody DeliveryProduct deliveryProduct) {

        return deliveryService.addProductDelivery(
                deliveryId,
                deliveryProduct.getProductId(),
                deliveryProduct.getQuantity()
        );
    }
}
