package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService {

    private final ProductRepository productRepository;

    @Autowired
    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product update(String id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setAisle(updatedProduct.getAisle());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
