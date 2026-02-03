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
import java.util.List;

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

    public DeliveryProduct addProductDelivery(Long deliveryId, Long productId, Double  quantity) {

        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставку с данным ID " + deliveryId));

        SupplierProduct price = supplierProductRepository.findBySupplierIdAndProductId(delivery.getSupplierId(), productId)
                .orElseThrow(() -> new RuntimeException("У поставщика нет товара  с данным ID " + productId));

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

    public Delivery confirmDelivery(Long id){
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставку с данным ID " + id));

        delivery.setStatus("Подтверждена");

        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDelivery(){
        return deliveryRepository.findAll();
    }

    public Delivery cancelDelivery(Long id){
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставку с данным ID " + id));

        delivery.setStatus("Отменена");

        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id){
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не удалось найти поставку с данным ID " + id));

        deliveryRepository.delete(delivery);
    }


}
