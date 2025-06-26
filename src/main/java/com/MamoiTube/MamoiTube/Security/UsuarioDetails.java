/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Security;

import com.MamoiTube.MamoiTube.Entidades.Usuario;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author mr587
 */
public class UsuarioDetails implements UserDetails{
    private final Usuario cliente;

    public UsuarioDetails(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Sin roles por ahora
    }

    @Override
    public String getPassword() {
        return cliente.getContraseña();
    }

    @Override
    public String getUsername() {
        return cliente.getCorreo(); 
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
