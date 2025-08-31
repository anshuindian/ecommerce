package com.example.ecommerce.entity;

import com.example.ecommerce.controller.java.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

public class OrderItem {



    @Id

    @GeneratedValue

    private Long
            id;

    @ManyToOne

    private Order
            order;

    @ManyToOne

    private Product
            product;

    private int quantity;

    private  String name;

    private double price;

    private String
            imageName;

    public void setProduct(Product dbProduct) {
    }

    public void setPrice(double price) {
    }

    public void setQuantity(int i) {
    }

    public void setOrder(org.springframework.core.annotation.Order order) {
    }
}
