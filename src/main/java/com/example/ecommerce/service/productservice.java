package com.example.ecommerce.service;

import com.example.ecommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ProductService {

    @Autowired
    private productRepository.ProductRepository productRepository;

    // Fetch all products
    public <Product> List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Fetch product by ID
    public <Product> Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add or update product
    public <Product> Object saveProduct(Product product) {
        return (Product) (Product) productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
