package com.example.reporte.service;

import com.example.reporte.model.Empleado;
import com.example.reporte.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para obtener empleados filtrados
    public List<Empleado> obtenerEmpleadosFiltrados(LocalDate fechaInicio, LocalDate fechaFin, String area) {
        // Convertir LocalDate a LocalDateTime al inicio y fin del día
        LocalDateTime inicio = fechaInicio.atStartOfDay();
        LocalDateTime fin = fechaFin.atTime(23, 59, 59);

        return empleadoRepository.findEmpleadosByFechaAndArea(inicio, fin, area);
    }
}
