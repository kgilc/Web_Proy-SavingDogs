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

import com.ipn.mx.domain.Propietario;
import com.ipn.mx.services.PropietarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apipropietario")
public class PropietarioController {
    @Autowired
    PropietarioService service;
    
    @GetMapping("/Propietarios")
    public List<Propietario> readAll(){
        return service.findAll();
    }
    
    @DeleteMapping("/Propietarios/{id}")
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
    
    @GetMapping("/Propietarios/{id}")
    public Propietario read(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/Propietarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Propietario update(@RequestBody Propietario propietario, @PathVariable Long id) {
        Propietario c = service.findById(id);
        return service.save(c);
    }

    @PostMapping("/Propietarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Propietario create(@RequestBody Propietario propietario) {
        return service.save(propietario);
    }
}
