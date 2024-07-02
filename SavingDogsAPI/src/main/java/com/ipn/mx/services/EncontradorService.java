package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.PerroEncontrado;

public interface EncontradorService {
	
	public List<Encontrador> findAll();
	public Encontrador findById(Long id);
    List<Encontrador> findBycorreoEncontrado (String correoEncontrado);
	public Encontrador save (Encontrador tarea);
	public void delete(Long id);

}
