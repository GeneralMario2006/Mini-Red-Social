/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mr587
 */
public class LikeId {
    private Long publicacion;
   

    public LikeId() {
    }

    public LikeId(Long publicacion) {
        
        this.publicacion = publicacion;
    }

    

  

    public Long getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Long publicacion) {
        this.publicacion = publicacion;
    }



}
