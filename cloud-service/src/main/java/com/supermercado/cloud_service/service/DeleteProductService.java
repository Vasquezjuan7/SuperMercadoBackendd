package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {

    private final ProductRepository productRepository;

    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
