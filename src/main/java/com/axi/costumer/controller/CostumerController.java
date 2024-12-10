package com.axi.costumer.controller;

import com.axi.costumer.entities.Empleados;
import com.axi.costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CostumerController {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Empleados input) {
        // Buscar empleado por email
        Optional<Empleados> optionalEmpleado = costumerRepository.findByEmail(input.getEmail());

        if (optionalEmpleado.isPresent()) {
            Empleados empleado = optionalEmpleado.get();
            // Verificar la contraseña
            if (passwordEncoder.matches(input.getPassword(), empleado.getPassword())) {
                 return ResponseEntity.ok().build();// Login exitoso
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Credenciales incorrectas
    }
}
