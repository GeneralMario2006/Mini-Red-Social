/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Repositorys;

import com.MamoiTube.MamoiTube.Entidades.Like;
import com.MamoiTube.MamoiTube.Entidades.Publicacion;
import com.MamoiTube.MamoiTube.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mr587
 */
@Repository
public interface LikesRepository extends JpaRepository<Like, Long>{
    Long countByPublicacionId(Long publicacionId);

    // Saber si un usuario ya dio like a una publicación
boolean existsByUsuarioIdAndPublicacionId(Long usuarioId, Long publicacionId);

}
