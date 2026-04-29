package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveProductService {

    private final ProductRepository productRepository;

    @Autowired
    public SaveProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
