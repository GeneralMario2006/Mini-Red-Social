package com.MamoiTube.MamoiTube.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    // Ruta de la imagen
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name= "autor_id")
    private Usuario autor;
    
    @OneToMany(mappedBy="publicacion")
    List<Comentarios> comentarios= new ArrayList<>();
    

    // Likes asociados
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    public Publicacion() {
        
    }

    public Publicacion(String titulo, String descripcion, String rutaImagen, Usuario autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.autor = autor;
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
