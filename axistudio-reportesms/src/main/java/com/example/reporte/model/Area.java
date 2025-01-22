package com.example.reporte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArea;

    @Column(name = "nombre_area", nullable = false, length = 20)
    private String nombreArea;

    @Column(name = "descripcion_area", nullable = false, length = 50)
    private String descripcionArea;

    @Column(name = "estatus", length = 1)
    private String estatus;
}
