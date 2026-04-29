package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.SaveProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class CreateProductController {

    private final SaveProductService saveProductService;

    @Autowired
    public CreateProductController(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product newProduct) {
        Product savedProduct = saveProductService.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
