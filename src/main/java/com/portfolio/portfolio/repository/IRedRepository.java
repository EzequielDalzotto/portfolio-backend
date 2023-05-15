/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Red;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezequiel
 */
@Repository
public interface IRedRepository extends JpaRepository<Red, Integer>{
    public Optional<Red> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}
