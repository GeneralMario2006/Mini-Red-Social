/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Repositorys;

import com.MamoiTube.MamoiTube.Entidades.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mr587
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByCorreo(String correo);
    
}
