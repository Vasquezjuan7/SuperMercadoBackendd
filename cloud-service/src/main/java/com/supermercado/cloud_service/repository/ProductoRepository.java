package com.supermercado.cloud_service.repository;

import com.supermercado.cloud_service.model.producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<producto, String> {
}