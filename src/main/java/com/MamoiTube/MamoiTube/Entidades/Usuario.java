/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author mr587
 */
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String usuario; 
    
    @Column(name="correo", unique=true)
    String correo;
    
    String contraseña;
    
     @OneToMany(mappedBy = "autor")
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "usuario")
    private List<Like> likes;
    
    @OneToMany(mappedBy= "usuario")
    public List<Comentarios> comentarios;

    
    public Usuario() {
    }

    public Usuario(String usuario, String correo, String contraseña) {
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
