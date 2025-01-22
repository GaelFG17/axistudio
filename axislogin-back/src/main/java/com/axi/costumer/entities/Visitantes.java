/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axi.costumer.entities;

/**
 *
 * @author gaelfranco
 */
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visitantes")
public class Visitantes {

    @Id
    @Column(name = "clv_Visitantes", length = 5, nullable = false)
    private String clvVisitantes;
    
    @Column(name = "Nombre_v", nullable = false, length = 40)
    private String nombre;
    
    @Column(name = "Ap1_v", nullable = false, length = 40)
    private String ap1;

    @Column(name = "Ap2_v", nullable = false, length = 40)
    private String ap2;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) // FK hacia Rol
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false) // FK hacia Area
    private Area area;

    @Column(name = "estatus", length = 1, nullable = false)
    private char estatus;

    @Column(name = "hora_entrada", nullable = false)
    private String horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    @Column(name = "usuario_nombre", length = 15, nullable = false)
    private String usuarioNombre;

    @Column(name = "contrasenia", length = 32, nullable = false)
    private String contrasenia;
}
