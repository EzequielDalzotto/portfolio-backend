/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Certificado;
import com.portfolio.portfolio.repository.ICertificadoRepository;
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
public class SCertificado {
    @Autowired
    ICertificadoRepository rCertificado;
    
    public List<Certificado> list(){
        return rCertificado.findAll();
    }
    
    public Optional<Certificado> getOne(int id){
        return rCertificado.findById(id);
    }
    
    public Optional<Certificado> getByNombre(String nombre){
        return rCertificado.findByNombre(nombre);
    }
    
    public void save(Certificado certificado){
        rCertificado.save(certificado);
    }
    
    public void delete(int id){
        rCertificado.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCertificado.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rCertificado.existsByNombre(nombre);
    }
}
