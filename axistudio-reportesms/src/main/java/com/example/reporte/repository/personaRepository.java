package com.example.reporte.repository;

import com.example.reporte.model.persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personaRepository extends JpaRepository<persona, String> {
}
