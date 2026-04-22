package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
public class DeleteProductController {

    private final ProductService productService;

    @Autowired
    public DeleteProductController(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
