/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Proyecto;
import com.portfolio.portfolio.repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel
 */
@Service
@Transactional
public class SProyecto {
    @Autowired
    IProyectoRepository rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByTitulo(String titulo){
        return rProyecto.findByTitulo(titulo);
    }
    
    public void save(Proyecto exp){
        rProyecto.save(exp);
    }
    
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
         return rProyecto.existsById(id);
     }
     
     public boolean existsByTitulo(String titulo){
         return rProyecto.existsByTitulo(titulo);
     }
}
