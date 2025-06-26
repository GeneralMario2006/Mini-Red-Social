/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.ClasesDTO;

/**
 *
 * @author mr587
 */
public class ComentariosDTO {
    String message;
    Long idPublicacion;

    public ComentariosDTO() {
    }

    public ComentariosDTO(String message, Long idPublicacion) {
        this.message = message;
        this.idPublicacion = idPublicacion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    
}
