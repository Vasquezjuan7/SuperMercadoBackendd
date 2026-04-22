package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public class UpdateProductController {

    private final ProductService productService;

    @Autowired
    public UpdateProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, product));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
