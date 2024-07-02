package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.Propietario;

public interface PropietarioService {
	
	public List<Propietario> findAll();
	public Propietario findById(Long id);
	public Propietario save (Propietario tarea);
	public void delete(Long id);
    List<Propietario> findBycorreoPerdido (String correoPerdido);



}
