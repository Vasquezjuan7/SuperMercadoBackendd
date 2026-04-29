package com.supermercado.cloud_service.controller;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class StockController {

    private final ProductService productService;

    @Autowired
    public StockController(ProductService productService) {
        this.productService = productService;
    }

    @PatchMapping("/{id}/stock")
    public Product adjustStock(@PathVariable String id, @RequestParam String action) {
        return productService.adjustStock(id, action);
    }
}
