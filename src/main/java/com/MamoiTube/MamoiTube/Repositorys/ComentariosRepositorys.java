/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Repositorys;

import com.MamoiTube.MamoiTube.Entidades.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mr587
 */
@Repository
public interface ComentariosRepositorys extends JpaRepository<Comentarios, Long> {
    
}
