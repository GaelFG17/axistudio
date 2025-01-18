package com.axi.costumer.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private int idRol;

    @Column(name = "nombre_rol", length = 20, nullable = false)
    private String nombreRol;

    @Column(name = "descripcion_rol", length = 50, nullable = false)
    private String descripcionRol;

    @Column(name = "estatus", length = 1, nullable = false)
    private char estatus;
}
