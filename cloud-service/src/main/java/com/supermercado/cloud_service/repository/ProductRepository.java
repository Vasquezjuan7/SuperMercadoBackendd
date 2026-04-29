package com.supermercado.cloud_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.supermercado.cloud_service.model.Product;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByAisle(String aisle);
}