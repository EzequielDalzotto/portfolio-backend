/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Usuario;
import com.portfolio.portfolio.service.SUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ezequiel
 */
@RestController
@RequestMapping("usuarios")//http://localhost:4200/usuarios
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    SUsuario sUsuario;
    
    @GetMapping("/traer")
    public List<Usuario> getUsuario(){
        return sUsuario.getUsuario();
    }
    
    @GetMapping("/detalle/{id}")
    public Usuario getByUsername(@PathVariable int id){
        return sUsuario.findUsuario(id);
    }
    
    @PostMapping("/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        sUsuario.saveUsuario(usuario);
        return "Usuario creado exitosamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteUsuario(@PathVariable int id){
        sUsuario.deleteUsuario(id);
        return "usuario eliminado exitosamente";
    }
    
    @PutMapping("/editar/{id}")
    public Usuario editUsuario(
            @PathVariable int id,
            @RequestParam("username") String nuevoUsername,
            @RequestParam("password") String nuevoPassword,
            @RequestParam("email") String nuevoEmail){
        
        Usuario usuario = sUsuario.findUsuario(id);
        usuario.setUsername(nuevoUsername);
        usuario.setPassword(nuevoPassword);
        usuario.setEmail(nuevoEmail);
        
        sUsuario.saveUsuario(usuario);
        return usuario;
    }
    
}
