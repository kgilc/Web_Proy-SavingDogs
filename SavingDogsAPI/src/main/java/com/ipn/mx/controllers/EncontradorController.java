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

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.services.EncontradorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiencontrador")
public class EncontradorController {
    @Autowired
    EncontradorService service;
    
    @GetMapping("/encontrador")
    public List<Encontrador> readAll(){
        return service.findAll();
    }
    
    @DeleteMapping("/encontrador/{id}")
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
    
    @GetMapping("/encontrador/{id}")
    public Encontrador read(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/encontrador/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Encontrador update(@RequestBody Encontrador encontrador, @PathVariable Long id) {
        Encontrador c = service.findById(id);
        return service.save(c);
    }

    @PostMapping("/encontrador")
    @ResponseStatus(HttpStatus.CREATED)
    public Encontrador create(@RequestBody Encontrador encontrador) {
        return service.save(encontrador);
    }
}
