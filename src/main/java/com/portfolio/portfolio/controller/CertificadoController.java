/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.DtoCertificado;
import com.portfolio.portfolio.entity.Certificado;
import com.portfolio.portfolio.security.controller.Mensaje;
import com.portfolio.portfolio.service.SCertificado;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ezequiel
 */
@RestController
@RequestMapping("certs")
@CrossOrigin(origins = "https://ezequieldalzottoportfolio.web.app")
public class CertificadoController {
    @Autowired
    SCertificado sCertificado;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Certificado>> list(){
        List<Certificado> list = sCertificado.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Certificado> getById(@PathVariable("id") int id){
        if(!sCertificado.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Certificado certificado = sCertificado.getOne(id).get();
        return new ResponseEntity(certificado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoCertificado dtocert){      
        if(StringUtils.isBlank(dtocert.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sCertificado.existsByNombre(dtocert.getNombre()))
            return new ResponseEntity(new Mensaje("Esa certificado existe"), HttpStatus.BAD_REQUEST);
        
        Certificado certificado = new Certificado(dtocert.getNombre(), dtocert.getImg());
        sCertificado.save(certificado);
        
        return new ResponseEntity(new Mensaje("Certificado agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoCertificado dtocert){
        //Validamos si existe el ID
        if(!sCertificado.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de certificados
        if(sCertificado.existsByNombre(dtocert.getNombre()) && sCertificado.getByNombre(dtocert.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa certificado ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtocert.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Certificado certificado = sCertificado.getOne(id).get();
        certificado.setNombre(dtocert.getNombre());
        certificado.setImg(dtocert.getImg());
        
        sCertificado.save(certificado);
        return new ResponseEntity(new Mensaje("Certificado actualizada"), HttpStatus.OK);
             
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sCertificado.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sCertificado.delete(id);
        return new ResponseEntity(new Mensaje("certificado eliminada"), HttpStatus.OK);
    }
}
