package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.perroPerdido;

public interface PerroEncontradoRepository extends CrudRepository<PerroEncontrado, Long> {
	
    List<PerroEncontrado> findByColorAndRaza(String color, String raza);
    List<PerroEncontrado> findByCorreo(String correo);


}
