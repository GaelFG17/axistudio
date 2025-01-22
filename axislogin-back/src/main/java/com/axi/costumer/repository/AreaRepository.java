/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.axi.costumer.repository;

import com.axi.costumer.entities.Area;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gaelfranco
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByNombreArea(String nombreArea);
}
