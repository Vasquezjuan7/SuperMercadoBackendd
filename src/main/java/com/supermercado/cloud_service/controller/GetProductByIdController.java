package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.GetProductByIdService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class GetProductByIdController {

    private final GetProductByIdService getProductByIdService;

    @Autowired
    public GetProductByIdController(GetProductByIdService getProductByIdService) {
        this.getProductByIdService = getProductByIdService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return getProductByIdService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
