/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.axi.costumer.repository;

import com.axi.costumer.entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gaelfranco
 */
public interface CostumerRepository extends JpaRepository<Empleados, Long> {
    Empleados findByEmailAndPassword(String email, String password);
}
