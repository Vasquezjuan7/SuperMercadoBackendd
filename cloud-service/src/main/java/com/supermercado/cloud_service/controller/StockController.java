package com.supermercado.cloud_service.controller;

import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.service.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class StockController {

    private final StockManagementService stockManagementService;

    @Autowired
    public StockController(StockManagementService stockManagementService) {
        this.stockManagementService = stockManagementService;
    }

    @PatchMapping("/{id}/stock")
    public Product adjustStock(@PathVariable String id, @RequestParam String action) {
        return stockManagementService.adjustStock(id, action);
    }
}
