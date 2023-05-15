/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.entity.Usuario;
import java.util.List;

/**
 *
 * @author Ezequiel
 */
public interface IUsuarioSerivice {
    //Listado de Usuarios
    public List<Usuario> getUsuario();
    
    //Guarda el Usuario
    public void saveUsuario(Usuario usuario);
    
    //Borra el Usuario
    public void deleteUsuario(int id);
    
    //Busca un Usuario por id
    public Usuario findUsuario(int id);
    
}
