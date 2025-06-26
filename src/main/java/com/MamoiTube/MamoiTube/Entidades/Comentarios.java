/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author mr587
 */
@Entity
@Table(name= "Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @ManyToOne
    @JoinColumn(name="publicacion_id")
    Publicacion publicacion;
    
    @ManyToOne
    @JoinColumn(name= "autor_id")
    Usuario usuario;
    
    String comentario;

    public Comentarios() {
    }

    public Comentarios(Publicacion publicacion, Usuario usuario, String comentario) {
        this.publicacion = publicacion;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
    
    
}
