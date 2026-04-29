package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GetProductByIdService {

    private final ProductRepository productRepository;

    @Autowired
    public GetProductByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getById(String id) {
        return productRepository.findById(id);
    }
}
