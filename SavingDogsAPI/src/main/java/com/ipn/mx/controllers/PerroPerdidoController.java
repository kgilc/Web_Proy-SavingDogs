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

import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.services.PerroPerdidoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiPerroperdido")
public class PerroPerdidoController {
    @Autowired
    PerroPerdidoService service;
    
    @GetMapping("/perroperdido")
    public List<perroPerdido> readAll(){
        return service.findAll();
    }
    
    @DeleteMapping("/perroperdido/{id}")
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
    
    @GetMapping("/perroperdido/{id}")
    public perroPerdido read(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/perroperdido/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public perroPerdido update(@RequestBody perroPerdido perroperdido, @PathVariable Long id) {
        perroPerdido c = service.findById(id);
        return service.save(c);
    }

    @PostMapping("/perroperdido")
    @ResponseStatus(HttpStatus.CREATED)
    public perroPerdido create(@RequestBody perroPerdido encontrador) {
        return service.save(encontrador);
    }
}
