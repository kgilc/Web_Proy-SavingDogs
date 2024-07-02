package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.perroPerdido;


public interface PerroPerdidoRepository extends CrudRepository<perroPerdido,Long> {
	
    List<perroPerdido> findBycolorAndRaza(String color, String raza);
    List<perroPerdido> findByCorreo(String correo);



}
