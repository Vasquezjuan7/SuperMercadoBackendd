package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockManagementService {

    private final ProductRepository productRepository;

    @Autowired
    public StockManagementService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product adjustStock(String id, String action) {
        return productRepository.findById(id).map(product -> {
            if ("IN".equalsIgnoreCase(action)) {
                product.setQuantity(product.getQuantity() + 1);
            } else if ("OUT".equalsIgnoreCase(action)) {
                if (product.getQuantity() > 0) {
                    product.setQuantity(product.getQuantity() - 1);
                }
            }
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product updateStock(String id, int quantity) {
        return productRepository.findById(id).map(product -> {
            product.setQuantity(quantity);
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
