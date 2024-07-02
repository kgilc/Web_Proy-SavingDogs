package com.ipn.mx.services;

import java.util.List;
import com.ipn.mx.domain.PerroEncontrado;

public interface PerroEncontradoService {
    List<PerroEncontrado> findAll();
    PerroEncontrado findById(Long id);
    PerroEncontrado save(PerroEncontrado perroencontrado);
    void delete(Long id);
    PerroEncontrado registroEncontrado(PerroEncontrado perroencontrado);
    //PerroEncontrado getEncontrado(Long id);
}
