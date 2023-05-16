/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.DtoHabilidadh;
import com.portfolio.portfolio.entity.Habilidadh;
import com.portfolio.portfolio.security.controller.Mensaje;
import com.portfolio.portfolio.service.SHabilidadh;
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
@RequestMapping("/skillh")
@CrossOrigin(origins = "https://ezequieldalzottoportfolio.web.app")
public class CHabilidadh {
    
    @Autowired
    SHabilidadh shabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidadh>> list() {
        List<Habilidadh> list = shabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidadh dtohabilidad) {
        if (StringUtils.isBlank(dtohabilidad.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shabilidad.existsByNombre(dtohabilidad.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidadh habilidad = new Habilidadh(dtohabilidad.getNombre(), dtohabilidad.getPorcentaje());
        shabilidad.save(habilidad);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidadh dtohabilidad) {
        //Validamos si existe el ID
        if (!shabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shabilidad.existsByNombre(dtohabilidad.getNombre()) && shabilidad.getByNombre(dtohabilidad.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohabilidad.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidadh habilidad = shabilidad.getOne(id).get();
        habilidad.setNombre(dtohabilidad.getNombre());
        habilidad.setPorcentaje(dtohabilidad.getPorcentaje());

        shabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
