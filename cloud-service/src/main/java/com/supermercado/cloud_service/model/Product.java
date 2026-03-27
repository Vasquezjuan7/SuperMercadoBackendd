package com.supermercado.cloud_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;  // Antes: nombre
    private String aisle; // Antes: pasillo

    public Product() {}

    // Getters y Setters actualizados
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAisle() { return aisle; }
    public void setAisle(String aisle) { this.aisle = aisle; }
}