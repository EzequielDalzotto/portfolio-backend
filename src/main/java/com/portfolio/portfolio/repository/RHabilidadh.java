/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Habilidadh;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ezequiel
 */
public interface RHabilidadh extends JpaRepository<Habilidadh, Integer>{
    Optional<Habilidadh> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
