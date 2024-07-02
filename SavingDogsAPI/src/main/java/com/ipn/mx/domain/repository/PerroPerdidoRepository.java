package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.perroPerdido;


public interface PerroPerdidoRepository extends CrudRepository<perroPerdido,Long> {
	
    List<perroPerdido> findByColorAndRaza(String color, String raza);


}
