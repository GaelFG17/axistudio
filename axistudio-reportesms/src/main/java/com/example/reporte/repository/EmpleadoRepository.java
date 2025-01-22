package com.example.reporte.repository;

import com.example.reporte.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    @Query("SELECT e FROM Empleado e " +
            "WHERE e.area.nombreArea = :area " +
            "AND e.horaEntrada BETWEEN :fechaInicio AND :fechaFin")
    List<Empleado> findEmpleadosByFechaAndArea(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("area") String area);
}
