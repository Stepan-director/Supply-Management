package com.example.Supply_Management.service;

import com.example.Supply_Management.model.Delivery;
import com.example.Supply_Management.model.DeliveryProduct;
import com.example.Supply_Management.model.Supplier;
import com.example.Supply_Management.model.SupplierProduct;
import com.example.Supply_Management.repository.DeliveryProductRepository;
import com.example.Supply_Management.repository.DeliveryRepository;
import com.example.Supply_Management.repository.SupplierProductRepository;
import com.example.Supply_Management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryProductRepository deliveryProductRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    public Delivery createDelivery(Long supplierId){
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставщика с данным ID " + supplierId));

        Delivery delivery = new Delivery();
        delivery.setSupplierId(supplierId);
        delivery.setSupplierName(supplier.getName());
        delivery.setDeliveryDate(LocalDate.now());
        delivery.setAmount(0.0);
        delivery.setStatus("Создана");

        return deliveryRepository.save(delivery);
    }

    public DeliveryProduct addProductDelivery(Long deliveryId, Long productId, double quantity) {

        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставку с данным ID " + ));

        SupplierProduct price = supplierProductRepository
                .findBySupplierIdAndProductId(delivery.getSupplierId(), productId)
                .orElseThrow(() -> new RuntimeException("У поставщика нет этого товара"));

        double endPrice = price.getPrice();

        double total = quantity * endPrice;

        DeliveryProduct deliveryProduct = new DeliveryProduct();
        deliveryProduct.setDeliveryId(deliveryId);
        deliveryProduct.setProductId(productId);
        deliveryProduct.setQuantity(quantity);
        deliveryProduct.setPrice(endPrice);
        deliveryProduct.setTotalAmount(total);

        DeliveryProduct saved = deliveryProductRepository.save(deliveryProduct);

        double newTotal = delivery.getAmount() + total;
        delivery.setAmount(newTotal);
        deliveryRepository.save(delivery);

        return saved;
    }

}
