package com.axi.costumer.controller;

import com.axi.costumer.entities.Empleados;
import com.axi.costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.axi.costumer.config.AESUtil;
import com.axi.costumer.entities.Area;
import com.axi.costumer.entities.Rol;
import com.axi.costumer.repository.AreaRepository;
import com.axi.costumer.repository.RolRepository;

import java.util.Optional;
import org.springframework.context.annotation.Role;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CostumerController {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AreaRepository areaRepository; // Inyectar AreaRepository

    @Autowired
    private RolRepository rolRepository; // Inyectar RoleRepository


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
    public ResponseEntity<?> registerEmployee(@RequestBody RegisterEmployeeDTO newEmployeeDTO) {
        try {
            // Verificar si el email ya está en uso
            if (costumerRepository.findByEmail(newEmployeeDTO.getEmail()).isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está registrado.");
            }

            // Verificar si la clave del empleado ya existe
            if (costumerRepository.existsByClvEmpleados(newEmployeeDTO.getClvEmpleados())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ID del empleado ya existe.");
            }

            // Buscar el área y rol por sus nombres
            Optional<Area> optionalArea = areaRepository.findByNombreArea(newEmployeeDTO.getNombreArea());
            Optional<Rol> optionalRole = rolRepository.findByNombreRol(newEmployeeDTO.getNombreRol());

            if (optionalArea.isEmpty() || optionalRole.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Área o rol no encontrados.");
            }

            // Crear el objeto Empleados
            Empleados newEmployee = new Empleados();
            newEmployee.setClvEmpleados(newEmployeeDTO.getClvEmpleados()); // Asignar manualmente la clave primaria
            newEmployee.setNombre(newEmployeeDTO.getNombre());
            newEmployee.setAp1(newEmployeeDTO.getAp1());
            newEmployee.setAp2(newEmployeeDTO.getAp2());
            newEmployee.setEstatus(newEmployeeDTO.getEstatus().charAt(0));
            newEmployee.setHoraEntrada(newEmployeeDTO.getHoraEntrada());
            newEmployee.setHoraSalida(newEmployeeDTO.getHoraSalida());
            newEmployee.setEmail(newEmployeeDTO.getEmail());

            // Desencriptar y encriptar la contraseña
            String decryptedPassword = AESUtil.decrypt(newEmployeeDTO.getPassword());
            String encryptedPassword = passwordEncoder.encode(decryptedPassword);
            newEmployee.setPassword(encryptedPassword);

            // Asignar el área y el rol
            newEmployee.setArea(optionalArea.get());
            newEmployee.setRol(optionalRole.get());

            // Guardar el nuevo empleado
            costumerRepository.save(newEmployee);

            return ResponseEntity.status(HttpStatus.CREATED).body("Empleado registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el empleado.");
        }
    }

}
