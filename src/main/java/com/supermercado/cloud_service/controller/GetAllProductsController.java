package com.supermercado.cloud_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.GetAllProductsService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class GetAllProductsController {

    private final GetAllProductsService getAllProductsService;

    @Autowired
    public GetAllProductsController(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String aisle) {
        if (aisle != null && !aisle.isEmpty()) {
            return ResponseEntity.ok(getAllProductsService.getByAisle(aisle));
        }
        return ResponseEntity.ok(getAllProductsService.getAll());
    }
}
