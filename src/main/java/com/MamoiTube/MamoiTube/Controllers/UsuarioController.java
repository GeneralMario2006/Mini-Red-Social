package com.MamoiTube.MamoiTube.Controllers;

import com.MamoiTube.MamoiTube.ClasesDTO.UsuarioDTO;
import com.MamoiTube.MamoiTube.Entidades.Usuario;
import com.MamoiTube.MamoiTube.Security.JwtProvider;
import com.MamoiTube.MamoiTube.Services.UsuarioService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
   
    @Autowired
    JwtProvider jwt;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/CrearUsuario")
    public ResponseEntity<?>CrearUsuario(@RequestBody Usuario usuario){
        usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario creado");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody UsuarioDTO usuario){
        try{
        Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            usuario.getCorreo(), usuario.getContraseña()
        )
    );
        String tokenUsername= jwt.generateToken(usuario.getCorreo());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("token", tokenUsername));
        }catch(AuthenticationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credenciales incorrectas.");
        }
    }
    
}
