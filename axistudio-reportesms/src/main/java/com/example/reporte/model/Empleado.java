package com.example.reporte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @Column(name = "clv_empleados", nullable = false, length = 15)
    private String clvEmpleados;
    
    @Column(name = "Nombre", nullable = false, length = 40)
    private String nombre;
    
    @Column(name = "Ap1", nullable = false, length = 40)
    private String ap1;

    @Column(name = "Ap2", nullable = false, length = 40)
    private String ap2;
    
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    @Column(name = "hora_entrada", nullable = false)
    private LocalDateTime horaEntrada; // Asegúrate de que la base de datos tenga esta columna

    @Column(name = "hora_salida", nullable = true)
    private LocalDateTime horaSalida; // Asegúrate de que la base de datos tenga esta columna

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "password", nullable = false, length = 90)
    private String password;

    @Column(name = "estatus", nullable = false)
    private char status;
}
