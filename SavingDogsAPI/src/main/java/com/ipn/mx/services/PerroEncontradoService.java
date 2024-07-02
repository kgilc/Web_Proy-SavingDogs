package com.ipn.mx.services;

import java.util.List;
import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.perroPerdido;

public interface PerroEncontradoService {
    List<PerroEncontrado> findAll();
    PerroEncontrado findById(Long id);
    PerroEncontrado save(PerroEncontrado perroencontrado);
    void delete(Long id);
    PerroEncontrado registroEncontrado(PerroEncontrado perroencontrado);
    List<PerroEncontrado> findByCorreo (String correo);
    //List<PerroEncontrado> findBycolorAndraza (String color, String raza);

}
