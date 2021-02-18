package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDAO extends MongoRepository<Product, String> {
    Product findByName(String name);
    void deleteProductByName(String name);
}
