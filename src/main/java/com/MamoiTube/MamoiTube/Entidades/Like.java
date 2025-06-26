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
@Table(name= "likes")
public class Like {
    
    @Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
public Long id;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "publicacion_id", nullable= false)
    private Publicacion publicacion;
    
    
    public Like() {
    }

    public Like(Usuario usuario, Publicacion publicacion) {
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    
}
