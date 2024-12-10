/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axi.costumer.entities;
import jakarta.persistence.*;
import lombok.Data;
/**
 *
 * @author gaelfranco
 */

@Data
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "clv_persona", length = 5, nullable = false)
    private String clvPersona;

    @Column(name = "nombre_persona", length = 20, nullable = false)
    private String nombrePersona;

    @Column(name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "CURP", length = 18, nullable = false)
    private String curp;

    @Column(name = "RFC", length = 13, nullable = false)
    private String rfc;

    @Column(name = "correo_electronico", length = 20, nullable = false)
    private String correoElectronico;
}
