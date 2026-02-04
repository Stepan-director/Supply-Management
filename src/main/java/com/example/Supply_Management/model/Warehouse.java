package com.example.Supply_Management.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Warehouse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    private String variety;

    @Column(nullable = false)
    private Double quantity;

    @Column(name = "measure_unit")
    private String measureUnit = "кг";

    @Column(name = "received_date", nullable = false)
    private LocalDate receivedDate;

    public Warehouse(Long id, Long productId, String productName, String productType, String variety, Double quantity, String measureUnit, LocalDate receivedDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.variety = variety;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        this.receivedDate = receivedDate;
    }

    public Warehouse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }
}
