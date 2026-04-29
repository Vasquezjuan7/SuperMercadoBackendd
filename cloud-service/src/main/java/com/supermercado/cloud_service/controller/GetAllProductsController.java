package com.supermercado.cloud_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class GetAllProductsController {

    private final ProductService productService;

    @Autowired
    public GetAllProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String aisle) {
        if (aisle != null && !aisle.isEmpty()) {
            return ResponseEntity.ok(productService.getProductsByAisle(aisle));
        }
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
