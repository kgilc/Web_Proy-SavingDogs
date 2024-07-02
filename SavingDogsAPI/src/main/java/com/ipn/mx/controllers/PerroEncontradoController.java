package com.ipn.mx.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.Propietario;
import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.domain.repository.PerroPerdidoRepository;
import com.ipn.mx.domain.repository.PropietarioRepository;
import com.ipn.mx.services.PerroEncontradoService;
import com.ipn.mx.services.PerroPerdidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiPerroencontrado")
public class PerroEncontradoController {

    @Autowired
    PerroEncontradoService service;
    
    @Autowired
    PerroPerdidoService perdidoservice;
    
    @Autowired
    private PerroPerdidoRepository perdidoRepository;
    
    @Autowired
    private PropietarioRepository contactarRepository;


    
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

    @PostMapping("/registroEncontrado")
    public ResponseEntity<?> registroEncontrado(@RequestBody PerroEncontrado perroencontrado) {
        try {
            PerroEncontrado savedPerro = service.registroEncontrado(perroencontrado);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("message", "Usuario guardado correctamente", "result", true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    
}
