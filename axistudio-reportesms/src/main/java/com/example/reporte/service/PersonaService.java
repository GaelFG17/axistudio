package com.example.reporte.service;

import com.example.reporte.model.persona;
import com.example.reporte.repository.personaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private personaRepository personaRepository;

    public List<persona> obtenerPersonas() {
        return personaRepository.findAll(); // Trae todas las personas
    }

    public persona guardarPersona(persona persona) {
        return personaRepository.save(persona); // Guarda una persona
    }
}
