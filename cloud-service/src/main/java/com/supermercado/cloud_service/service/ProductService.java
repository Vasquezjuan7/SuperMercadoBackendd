package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            System.err.println("Database Error - saving product: " + e.getMessage());
            throw new RuntimeException("Error saving product to database", e);
        }
    }

    public void deleteProduct(String id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Database Error - deleting product: " + e.getMessage());
            throw new RuntimeException("Error deleting product from database", e);
        }
    }

    public java.util.Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setAisle(updatedProduct.getAisle());
                    product.setQuantity(updatedProduct.getQuantity());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
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
}
