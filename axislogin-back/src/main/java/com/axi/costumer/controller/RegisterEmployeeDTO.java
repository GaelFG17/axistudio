/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axi.costumer.controller;

/**
 *
 * @author gaelfranco
 */
public class RegisterEmployeeDTO {
    private String clvEmpleados;
    private String Nombre;
    private String Ap1;
    private String Ap2;
    private String estatus;
    private String horaEntrada;
    private String horaSalida;
    private String email;
    private String password;
    private String nombreArea; // Nombre del área
    private String nombreRol; // Nombre del rol
    // Getters y setters

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

    public String getClvEmpleados() {
        return clvEmpleados;
    }

    public void setClvEmpleados(String clvEmpleados) {
        this.clvEmpleados = clvEmpleados;
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAp1() {
        return Ap1;
    }

    public void setAp1(String Ap1) {
        this.Ap1 = Ap1;
    }

    public String getAp2() {
        return Ap2;
    }

    public void setAp2(String Ap2) {
        this.Ap2 = Ap2;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
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

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
}
