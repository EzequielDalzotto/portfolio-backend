/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Habilidadh;
import com.portfolio.portfolio.repository.RHabilidadh;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel
 */
@Transactional
@Service
public class SHabilidadh {
    @Autowired
    RHabilidadh rhabilidad;
    
    
    public List<Habilidadh> list(){
        return rhabilidad.findAll();
    }
    
    public Optional<Habilidadh> getOne(int id){
        return rhabilidad.findById(id);
    }
    
    public Optional<Habilidadh> getByNombre(String nombre){
        return rhabilidad.findByNombre(nombre);
    }
    
    public void save(Habilidadh skill){
        rhabilidad.save(skill);
    }
    
    public void delete(int id){
        rhabilidad.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhabilidad.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhabilidad.existsByNombre(nombre);
    }

}