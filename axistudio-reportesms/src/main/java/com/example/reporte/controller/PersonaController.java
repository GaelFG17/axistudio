package com.example.reporte.controller;

import com.example.reporte.model.persona;
import com.example.reporte.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas") // Aquí definimos la URL base
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<persona> obtenerPersonas() {
        return personaService.obtenerPersonas(); // Llama al servicio
    }

    @PostMapping
    public persona guardarPersona(@RequestBody persona persona) {
        return personaService.guardarPersona(persona); // Llama al servicio
    }
}
