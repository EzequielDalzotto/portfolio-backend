/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Habilidads;
import com.portfolio.portfolio.repository.RHabilidads;
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
public class SHabilidads {
    @Autowired
    RHabilidads rhabilidads;
    
    
    public List<Habilidads> list(){
        return rhabilidads.findAll();
    }
    
    public Optional<Habilidads> getOne(int id){
        return rhabilidads.findById(id);
    }
    
    public Optional<Habilidads> getByNombre(String nombre){
        return rhabilidads.findByNombre(nombre);
    }
    
    public void save(Habilidads skill){
        rhabilidads.save(skill);
    }
    
    public void delete(int id){
        rhabilidads.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhabilidads.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhabilidads.existsByNombre(nombre);
    }

}
