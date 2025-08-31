package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class productRepository {
    public interface ProductRepository<Product> extends JpaRepository<Product, Long> {

    }
}

