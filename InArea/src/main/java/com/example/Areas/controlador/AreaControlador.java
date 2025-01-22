
package com.example.Areas.controlador;

import com.example.Areas.Area.area;
import com.example.Areas.repositorio.AreaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/areas")
public class AreaControlador {
 @Autowired
    private AreaRepositorio areaRepository;

    // Endpoint para obtener todas las áreas
    @GetMapping
    public List<area> getAllAreas() {
        return areaRepository.findAll();
    }   
}
