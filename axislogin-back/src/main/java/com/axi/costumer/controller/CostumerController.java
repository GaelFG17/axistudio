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


}
