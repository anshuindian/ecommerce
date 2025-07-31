package com.example.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity

@Table(name
        = "orders")

public class Order {


    @Id
    @GeneratedValue

    private Long
            id;

    private String
            userEmail;

    private LocalDateTime orderDate;

    private double totalAmount;

    @OneToMany(mappedBy
            = "order", cascade = CascadeType.ALL)
    public List<OrderItem> items = new ArrayList<>();

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public <OrderItem> List<OrderItem> getItems() {
        return (List<OrderItem>) items;
    }

    public <OrderItem> void setItems(List<OrderItem> items) {
        for (OrderItem item : this.items) {

        }

    }
}

