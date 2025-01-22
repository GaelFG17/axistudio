package com.example.reporte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visitantes")
public class Visitantes {

    @Id
    private String clvVisitantes;

    @ManyToOne
    @JoinColumn(name = "clv_persona", nullable = false)
    private persona persona;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    private char estatus;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private String usuarioNombre;
    private String contrasenia;
}
