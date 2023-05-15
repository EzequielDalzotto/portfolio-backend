/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ezequiel
 */
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
