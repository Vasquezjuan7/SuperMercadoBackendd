package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.service.DeleteProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
public class DeleteProductController {

    private final DeleteProductService deleteProductService;

    @Autowired
    public DeleteProductController(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        deleteProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
