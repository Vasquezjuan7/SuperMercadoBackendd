package com.supermercado.cloud_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.supermercado.cloud_service.model.producto;
import com.supermercado.cloud_service.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
// Usamos "*" para evitar bloqueos de CORS entre el puerto 5173 y 8080
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<producto> listarTodos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public producto guardar(@RequestBody producto nuevo) {
        try {
            // Esto guardará el objeto 'nombre' y 'pasillo' que envías desde React
            return productoRepository.save(nuevo);
        } catch (Exception e) {
            // Si sale error 500, esto imprimirá la causa real en tu terminal de VS Code
            System.out.println("ERROR AL GUARDAR EN ATLAS: " + e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        productoRepository.deleteById(id);
    }
}