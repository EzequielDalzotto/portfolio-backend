/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Ezequiel
 */
public class DtoExperiencia {
    @NotBlank
    private String img;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String img, String titulo, String descripcion) {
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
