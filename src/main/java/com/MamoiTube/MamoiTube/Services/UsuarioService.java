/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Services;

import com.MamoiTube.MamoiTube.Entidades.Usuario;
import com.MamoiTube.MamoiTube.Repositorys.UsuarioRepository;
import com.MamoiTube.MamoiTube.Validaciones.ValidarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mr587
 */
@Service
public class UsuarioService {
    
    @Autowired
    ServiceConfig serviceConfig;
    
    @Autowired
    ValidarUsuario validarUsuario;
    
    @Autowired 
    UsuarioRepository usuarioRepository;
    
    public void crearUsuario(Usuario usuario) {
       validarUsuario.verificarCorreo(usuario.getCorreo());
        
        try {
            Usuario crear= new Usuario();
            crear.setUsuario(usuario.getUsuario());
            crear.setCorreo(usuario.getCorreo());
            
          String rawPassword= serviceConfig.encryptPassword(usuario.getContraseña());
          crear.setContraseña(rawPassword);  
          usuarioRepository.save(crear);
          
        }catch(Exception e){
            System.out.println("error: "+e);
        }   
    }
    
    
}
