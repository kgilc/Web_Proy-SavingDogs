package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.Encontrador;

public interface EncontradorService {
	
	public List<Encontrador> findAll();
	public Encontrador findById(Long id);
	public Encontrador save (Encontrador tarea);
	public void delete(Long id);

}
