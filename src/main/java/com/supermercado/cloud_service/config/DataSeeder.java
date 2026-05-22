package com.supermercado.cloud_service.config;

import com.supermercado.cloud_service.model.User;
import com.supermercado.cloud_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setName("Juan Vasquez");
            admin.setUsername("Juan");
            admin.setPassword("Juan2026");
            admin.setRole("admin");
            userRepository.save(admin);
            System.out.println("Usuario administrador por defecto creado.");
        }
    }
}
