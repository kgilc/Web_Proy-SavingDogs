package com.ipn.mx.controllers;

import java.util.List;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiUsuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;
    
    @GetMapping("/usuarios")
    public List<Usuario> readAll(){
        return service.findAll();
    }
    
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
    
    @GetMapping("/usuarios/{id}")
    public Usuario read(@PathVariable Long id) {
        return service.findById(id);
    }
    
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

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }
}
