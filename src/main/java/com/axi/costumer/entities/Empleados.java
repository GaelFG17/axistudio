/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axi.costumer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/**
 *
 * @author gaelfranco
 */
@Entity
@Table(name = "empleados")
public class Empleados {

    @Id
    @Column(name = "clv_Empleados", length = 5, nullable = false)
    private String clvEmpleados;

    @ManyToOne
    @JoinColumn(name = "clv_persona", nullable = false) // FK hacia la tabla "persona"
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) // FK hacia la tabla "rol"
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false) // FK hacia la tabla "Area"
    private Area area;

    @Column(name = "estatus", length = 1, nullable = false)
    private char estatus;
    
    @Column(name = "hora_entrada", nullable = false)
    private String horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public String getClvEmpleados() {
        return clvEmpleados;
    }

    public void setClvEmpleados(String clvEmpleados) {
        this.clvEmpleados = clvEmpleados;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password", length = 90, nullable = false)
    private String password;
    
    
}