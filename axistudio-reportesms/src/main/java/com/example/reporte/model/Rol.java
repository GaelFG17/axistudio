package com.example.reporte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombre_rol", nullable = false, length = 20)
    private String nombreRol;

    @Column(name = "descripcion_rol", nullable = false, length = 50)
    private String descripcionRol;

    @Column(name = "estatus", length = 1)
    private String estatus;
}
