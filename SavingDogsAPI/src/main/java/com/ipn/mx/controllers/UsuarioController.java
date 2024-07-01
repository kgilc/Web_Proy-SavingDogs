package com.ipn.mx.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.domain.Usuario;
import com.ipn.mx.services.UsuarioService;

@RestController
@RequestMapping("/apiUsuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/usuarios")
    public List<Usuario> readAll(){
        return service.findAll();
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede eliminar el usuario");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioAutenticado = service.login(usuario.getCorreo(), usuario.getPassword());

            if (usuarioAutenticado != null) {
                Map<String, Object> userData = new HashMap<>();
                userData.put("nombre", usuarioAutenticado.getNombre());
                userData.put("id", usuarioAutenticado.getIdUsuario());

                return ResponseEntity.ok().body(Map.of("user", userData, "result", true));
            } else {
                return ResponseEntity.ok().body(Map.of("message", "Credenciales incorrectas", "result", false));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Error interno del servidor", "result", false));
        }
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario c = service.findById(id);
        c.setNombre(usuario.getNombre());
        c.setTelefono(usuario.getTelefono());
        c.setCorreo(usuario.getCorreo());
        c.setUbicacion(usuario.getUbicacion());
        return service.save(c);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }
}
