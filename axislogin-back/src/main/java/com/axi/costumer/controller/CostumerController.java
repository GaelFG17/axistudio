package com.axi.costumer.controller;

import com.axi.costumer.entities.Empleados;
import com.axi.costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.axi.costumer.config.AESUtil;

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
        try {
            // Desencriptar la contraseña recibida
            String decryptedPassword = AESUtil.decrypt(input.getPassword());

            Optional<Empleados> optionalEmpleado = costumerRepository.findByEmail(input.getEmail());

            if (optionalEmpleado.isPresent()) {
                Empleados empleado = optionalEmpleado.get();
                // Verificar la contraseña desencriptada con el hash almacenado
                if (passwordEncoder.matches(decryptedPassword, empleado.getPassword())) {
                    return ResponseEntity.ok().build();
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error procesando la solicitud");
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Empleados newEmployee) {
        try {
            // Verificar si el email ya está en uso
            Optional<Empleados> existingEmployee = costumerRepository.findByEmail(newEmployee.getEmail());
            if (existingEmployee.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está registrado.");
            }

            // Encriptar la contraseña antes de guardar
            String encryptedPassword = passwordEncoder.encode(newEmployee.getPassword());
            newEmployee.setPassword(encryptedPassword);

            // Guardar el nuevo empleado
            costumerRepository.save(newEmployee);

            return ResponseEntity.status(HttpStatus.CREATED).body("Empleado registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el empleado.");
        }
    }



}
