package com.MamoiTube.MamoiTube.Controllers;

import com.MamoiTube.MamoiTube.ClasesDTO.ComentariosDTO;
import com.MamoiTube.MamoiTube.ClasesDTO.PublicacionDTO;
import com.MamoiTube.MamoiTube.Entidades.LikeId;
import com.MamoiTube.MamoiTube.Services.PublicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/muro")
public class PublicacionController {
    
    @Autowired
    PublicacionService publicacionService;    
    
    
    @PostMapping("/publicaciones")
public ResponseEntity<?> subirPublicacion(@RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion, 
        @RequestParam("imagen") MultipartFile file, Principal principal) throws IOException {

    publicacionService.subirImagen(titulo, descripcion, file, principal);
    return ResponseEntity.ok("Publicación guardada");
}


@GetMapping("/{correo}/ver")
public ResponseEntity<?> verPublicaciones(@PathVariable String correo) {
    try {
    List<PublicacionDTO> publicaciones= publicacionService.verPublicaciones(correo);
    if(publicaciones.isEmpty()) {
        ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay publicaciones");
    }
    return ResponseEntity.ok(publicaciones);
    }catch(IllegalArgumentException e){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR "+ e.getMessage());
    }
    
}

@PostMapping("/DarLike")
public ResponseEntity<?>darLike(@RequestBody LikeId likes, Principal principal){
    try {    
publicacionService.DarLike(likes, principal);
return ResponseEntity.ok("Like registrado");
        } 
catch(IllegalArgumentException e){
 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+ e.getMessage());
  }
}

@PostMapping("/comentar")
public ResponseEntity<?>Comentar(@RequestBody ComentariosDTO messageAndId, Principal principal) {
    try {
        publicacionService.Comentar(messageAndId, principal);
        return ResponseEntity.ok("");
    }catch(IllegalArgumentException e) {
         return ResponseEntity.badRequest().body(e);
    }
}

}
