package com.supermercado.cloud_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;

@RestController
@RequestMapping("/api/products") 

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product newProduct) {
        try {

            return productRepository.save(newProduct);
        } catch (Exception e) {

            System.out.println("ERROR SAVING TO ATLAS: " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}
