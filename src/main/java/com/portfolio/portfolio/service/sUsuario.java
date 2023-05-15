/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.Interface.IUsuarioSerivice;
import com.portfolio.portfolio.entity.Usuario;
import com.portfolio.portfolio.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel
 */
@Transactional
@Service
public class SUsuario implements IUsuarioSerivice {
    
    @Autowired
    public IUsuarioRepository iUsuarioRepository;

    @Override
    public List<Usuario> getUsuario() {
        return iUsuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
        iUsuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(int id) {
        return iUsuarioRepository.findById(id).orElse(null);
    }
    
}
