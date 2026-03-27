package com.supermercado.cloud_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.supermercado.cloud_service.model.Product; // Importa el modelo ya en inglés

// La interfaz debe llamarse igual que el archivo físico
public interface ProductRepository extends MongoRepository<Product, String> {
}