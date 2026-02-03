package com.example.Supply_Management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_product")
public class DeliveryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_id")
    private Long deliveryId;

    @Column(name = "product_id")
    private Long productId;

    private Double  quantity;

    private Double  price;

    @Column(name = "total_amount")
    private double totalAmount;

    public DeliveryProduct(Long id, Long deliveryId, Long productId, Double  quantity, Double  price, Double  totalAmount) {
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

    public Double  getQuantity() {
        return quantity;
    }

    public void setQuantity(Double  quantity) {
        this.quantity = quantity;
    }

    public Double  getPrice() {
        return price;
    }

    public void setPrice(Double  price) {
        this.price = price;
    }

    public Double  getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double  totalAmount) {
        this.totalAmount = totalAmount;
    }
}
