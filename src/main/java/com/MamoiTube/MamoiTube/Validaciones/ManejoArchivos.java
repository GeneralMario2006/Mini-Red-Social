/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Validaciones;

import com.MamoiTube.MamoiTube.Entidades.Publicacion;
import com.MamoiTube.MamoiTube.Entidades.Usuario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mr587
 */
@Component
public class ManejoArchivos {
    
    
    
    public String SubirFoto(String titulo, String descripcion, MultipartFile file, Principal principal) throws IOException {
       String uploadDir = System.getProperty("user.dir") + "/uploads/";
Files.createDirectories(Paths.get(uploadDir));

String nombreArchivo = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
Path rutaCompleta = Paths.get(uploadDir, nombreArchivo);

//Files.copy(ORIGEN, DESTINO, OPCIÓN);
Files.copy(file.getInputStream(), rutaCompleta, StandardCopyOption.REPLACE_EXISTING);

return nombreArchivo;
    }
}
