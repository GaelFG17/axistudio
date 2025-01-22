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

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area", nullable = false)
    private int idArea;

    @Column(name = "nombre_area", length = 20, nullable = false)
    private String nombreArea;

    @Column(name = "descripcion_area", length = 50, nullable = false)
    private String descripcionArea;

    @Column(name = "estatus", length = 1, nullable = false)
    private char estatus;

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
    
}
