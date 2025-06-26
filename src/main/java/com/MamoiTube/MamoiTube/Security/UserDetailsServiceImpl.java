/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Security;

import com.MamoiTube.MamoiTube.Entidades.Usuario;
import com.MamoiTube.MamoiTube.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mr587
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
     @Autowired
    private UsuarioRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario cliente = clienteRepository.findByCorreo(correo)
                .stream()
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Cliente no encontrado con correo: " + correo));

        return new UsuarioDetails(cliente);
    }
}
