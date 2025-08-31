package com.example.ecommerce.entity;

import com.example.ecommerce.entity.OrderItem;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name
        = "orders")

public class Order implements org.springframework.core.annotation.Order {



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

    private List<OrderItem> items = new ArrayList<>();

    @Override
    public int value() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

