package com.example.ecommerce.controller.java;

public class Product {
    private long stock;
    private double price;

    public Object getId() {
        return null;
    }

    public long getStock() {
        return (int) stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return null;
    }
}
