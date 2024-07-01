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

import com.ipn.mx.domain.Registro;
import com.ipn.mx.domain.Usuario;
import com.ipn.mx.services.RegistroService;
import com.ipn.mx.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiRegistro")
public class RegistroController {
    @Autowired
    RegistroService service;
    
    @GetMapping("/registro")
    public List<Registro> readAll(){
        return service.findAll();
    }
    
    @DeleteMapping("/registro/{id}")
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
    public Registro read(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/registro/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Registro update(@RequestBody Registro registro, @PathVariable Long id) {
        Registro c = service.findById(id);
        return service.save(c);
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public Registro create(@RequestBody Registro registro) {
        return service.save(registro);
    }
}
