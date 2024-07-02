package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.Propietario;

public interface PropietarioRepository extends CrudRepository<Propietario,Long> {
	
    List<Propietario> findBycorreoPerdido (String correoPerdido);


}
