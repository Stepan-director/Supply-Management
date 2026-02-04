package com.example.Supply_Management.service;


import com.example.Supply_Management.DTO.ReportDTO;
import com.example.Supply_Management.model.Delivery;
import com.example.Supply_Management.model.DeliveryProduct;
import com.example.Supply_Management.model.Product;
import com.example.Supply_Management.model.Warehouse;
import com.example.Supply_Management.repository.DeliveryProductRepository;
import com.example.Supply_Management.repository.DeliveryRepository;
import com.example.Supply_Management.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private DeliveryProductRepository deliveryProductRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    public ReportDTO getDeliveryReport(LocalDate startDate, LocalDate endDate) {
        List<Warehouse> warehouseItems = warehouseRepository.findByReceivedDateBetween(startDate, endDate);

        ReportDTO report = new ReportDTO();

        for (Warehouse item : warehouseItems) {
            DeliveryProduct dp = deliveryProductRepository.findAll().stream().filter(d -> d.getProductId().equals(item.getProductId()))
                    .findFirst().orElse(null);

            if (dp == null) continue;

            Delivery delivery = deliveryRepository.findById(dp.getDeliveryId()).orElse(null);
            if (delivery == null) continue;

            report.addRecord(
                    delivery.getSupplierName(),
                    item.getProductName() + " " + item.getVariety(), item.getQuantity(), item.getQuantity() * dp.getPrice()
            );
        }
        return report;
    }


}
