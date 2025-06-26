/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Validaciones;

import com.MamoiTube.MamoiTube.ClasesDTO.UsuarioDTO;
import com.MamoiTube.MamoiTube.Entidades.Usuario;
import com.MamoiTube.MamoiTube.Repositorys.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mr587
 */
@Component
public class ValidarUsuario {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public void verificarCorreo(String correo) {
        Optional<Usuario> findUserCorreo= usuarioRepository.findByCorreo(correo);
        try {
            if (findUserCorreo.isPresent()){
                throw new IllegalArgumentException("El correo ya existe.");
            }
            
        }catch(Exception e){
            throw new IllegalArgumentException("Error. "+e);
        }
    }

}
