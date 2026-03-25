package com.supermercado.cloud_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "productos")
public class producto {
    @Id
    private String id;
    private String nombre;
    private String pasillo; 
    // Quitamos stockActual por ahora para que no cause error 500 si va vacío
}