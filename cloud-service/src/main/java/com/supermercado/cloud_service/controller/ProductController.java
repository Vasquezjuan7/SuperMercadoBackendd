package com.supermercado.cloud_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.Product;
import com.supermercado.cloud_service.repository.ProductRepository;

@RestController
@RequestMapping("/api/products") // Cambiado a inglés
// CORS configurado para permitir la comunicación con Vercel
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product newProduct) {
        try {
            // Recibe 'name' y 'aisle' desde el Frontend en React
            return productRepository.save(newProduct);
        } catch (Exception e) {
            // Imprime el error en la consola de Railway/VS Code si algo falla con MongoDB Atlas
            System.out.println("ERROR SAVING TO ATLAS: " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}