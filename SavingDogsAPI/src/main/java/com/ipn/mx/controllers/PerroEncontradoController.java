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

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.services.PerroEncontradoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiPerroencontrado")
public class PerroEncontradoController {
    @Autowired
    PerroEncontradoService service;
    
    @GetMapping("/perroencontrado")
    public List<PerroEncontrado> readAll(){
        return service.findAll();
    }
    
    @DeleteMapping("/perroencontrado/{id}")
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
    
    @GetMapping("/perroencontrado/{id}")
    public PerroEncontrado read(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping("/perroencontrado/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PerroEncontrado update(@RequestBody PerroEncontrado perroencontrado, @PathVariable Long id) {
        PerroEncontrado c = service.findById(id);
        return service.save(c);
    }

    @PostMapping("/perroencontrado")
    @ResponseStatus(HttpStatus.CREATED)
    public PerroEncontrado create(@RequestBody PerroEncontrado encontrador) {
        return service.save(encontrador);
    }
}
