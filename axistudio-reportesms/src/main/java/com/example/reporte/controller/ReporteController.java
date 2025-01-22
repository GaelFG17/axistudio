package com.example.reporte.controller;

import com.example.reporte.model.Empleado;
import com.example.reporte.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Empleado> generarReporte(
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaFin") LocalDate fechaFin,
            @RequestParam("area") String area) {
        return reporteService.obtenerEmpleadosFiltrados(fechaInicio, fechaFin, area);
    }
}
