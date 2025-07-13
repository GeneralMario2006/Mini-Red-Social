package com.MamoiTube.MamoiTube.Services;

import com.MamoiTube.MamoiTube.ClasesDTO.ComentariosDTO;
import com.MamoiTube.MamoiTube.ClasesDTO.PublicacionDTO;
import com.MamoiTube.MamoiTube.Entidades.Comentarios;
import com.MamoiTube.MamoiTube.Entidades.Like;
import com.MamoiTube.MamoiTube.Entidades.LikeId;
import com.MamoiTube.MamoiTube.Entidades.Publicacion;
import com.MamoiTube.MamoiTube.Entidades.Usuario;
import com.MamoiTube.MamoiTube.Repositorys.ComentariosRepositorys;
import com.MamoiTube.MamoiTube.Repositorys.LikesRepository;
import com.MamoiTube.MamoiTube.Repositorys.PublicacionRepository;
import com.MamoiTube.MamoiTube.Repositorys.UsuarioRepository;
import com.MamoiTube.MamoiTube.Validaciones.ManejoArchivos;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PublicacionService {
    @Autowired
    PublicacionRepository publicacionRepository;
    
    @Autowired
    LikesRepository likeRepository;
    
    @Autowired 
    UsuarioRepository usuarioRepository;
    
    @Autowired
    ManejoArchivos archivos;
    
    @Autowired
    ComentariosRepositorys comentarioRepo;
    
    public void subirImagen(String titulo, String descripcion, MultipartFile file, Principal principal) {
    try{
        String nombre= archivos.SubirFoto(titulo, descripcion, file, principal);    
            Usuario autor = usuarioRepository.findByCorreo(principal.getName()).orElseThrow();
                Publicacion publicacion = new Publicacion(titulo, descripcion, nombre, autor);
                    publicacionRepository.save(publicacion);
    }catch(Exception e) {
        System.out.println("Error "+ e.getLocalizedMessage());
    }
 
}
    public List<PublicacionDTO> verPublicaciones(String correo) {
    Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(()->new IllegalArgumentException("El usuario no existe. "));
        List<Publicacion> publicaciones = publicacionRepository.findByAutor_Id(usuario.getId());

            return publicaciones.stream().map(pub -> {
        List<String> comentarios = pub.getComentarios().stream()
            .map(Comentarios::getComentario)
            .collect(Collectors.toList());
        
        Long likes= likeRepository.countByPublicacionId(pub.getId());

        return new PublicacionDTO(
            pub.getId(),
            pub.getTitulo(),
            pub.getDescripcion(),
            pub.getRutaImagen(),
            comentarios,
                likes
        );
    }).collect(Collectors.toList());
    }
    
public void DarLike(LikeId likes, Principal principal) {
    Usuario buscarUsuario= usuarioRepository.findByCorreo(principal.getName()).orElseThrow(()->new IllegalArgumentException("El usuario no existe"));
    Publicacion buscarPubli= publicacionRepository.findById(likes.getPublicacion()).orElseThrow(()->new IllegalArgumentException("Publicacion no valida"));
    
    Long usuarioId = buscarUsuario.getId();
    Long publicacionId = buscarPubli.getId();

boolean likeSiOno= likeRepository.existsByUsuarioIdAndPublicacionId(usuarioId, publicacionId);

if (likeSiOno) {
   throw new IllegalArgumentException("Error ya diste like.");
}
   Like nuevo= new Like(buscarUsuario, buscarPubli);
   likeRepository.save(nuevo);
    }   

public void Comentar(ComentariosDTO messageAndId, Principal principal) {
    Usuario user= usuarioRepository.findByCorreo(principal.getName()).orElseThrow();
    Publicacion publicacion= publicacionRepository.findById(messageAndId.getIdPublicacion()).orElseThrow();
    String message= messageAndId.getMessage();
    
    Comentarios newComentary= new Comentarios(publicacion, user, message);
    comentarioRepo.save(newComentary);
}

}