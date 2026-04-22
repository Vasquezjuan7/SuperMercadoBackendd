package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class CreateProductController {

    private final ProductService productService;

    @Autowired
    public CreateProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product newProduct) {
        Product savedProduct = productService.saveProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
