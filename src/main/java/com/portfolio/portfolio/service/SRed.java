/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Red;
import com.portfolio.portfolio.repository.IRedRepository;
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
public class SRed {
    @Autowired
    IRedRepository rRed;
    
    public List<Red> list(){
        return rRed.findAll();
    }
    
    public Optional<Red> getOne(int id){
        return rRed.findById(id);
    }
    
    public Optional<Red> getByNombre(String nombre){
        return rRed.findByNombre(nombre);
    }
    
    public void save(Red exp){
        rRed.save(exp);
    }
    
    public void delete(int id){
        rRed.deleteById(id);
    }
    
    public boolean existsById(int id){
         return rRed.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rRed.existsByNombre(nombre);
    }
}
