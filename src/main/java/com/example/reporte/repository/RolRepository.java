package com.example.reporte.repository;

import com.example.reporte.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Empleado, String> {
}
