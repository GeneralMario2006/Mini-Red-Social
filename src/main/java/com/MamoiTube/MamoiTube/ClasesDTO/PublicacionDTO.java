/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.ClasesDTO;

import java.util.List;

/**
 *
 * @author mr587
 */
public class PublicacionDTO {
    Long id;
    String titulo, descripcion, rutaImagen;
    private List<String> comentarios;

    public PublicacionDTO(Long id, String titulo, String descripcion, String rutaImagen, List<String> comentarios) {
        this.id= id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.comentarios= comentarios;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
    
}
