    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package com.axi.costumer.controller;

    import com.axi.costumer.entities.Empleados;
    import com.axi.costumer.repository.CostumerRepository;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.bind.annotation.RequestMapping;
    import java.util.List;
    import java.util.Optional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;

    /**
     *
     * @author sotobotero
     */
    @RestController
    @RequestMapping("/customer")
    @CrossOrigin
    public class CostumerController {

        @Autowired
        CostumerRepository costumerRepository;

        @PostMapping
        public ResponseEntity<?> login(@RequestBody Empleados input) {
            // Busca un empleado en la base de datos por correo y contraseña
            Empleados empleado = costumerRepository.findByEmailAndPassword(input.getEmail(), input.getPassword());

            if (empleado != null) {
                return new ResponseEntity<>(empleado, HttpStatus.OK);  // Login exitoso
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);  // Credenciales incorrectas
            }
        }

    }
