package com.example.Supply_Management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_item")
public class DeliveryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_id")
    private Long deliveryId;

    @Column(name = "product_id")
    private Long productId;

    private double quantity;

    private double price;

    @Column(name = "total_amount")
    private double totalAmount;

    public DeliveryProduct(Long id, Long deliveryId, Long productId, double quantity, double price, double totalAmount) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    public DeliveryProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
