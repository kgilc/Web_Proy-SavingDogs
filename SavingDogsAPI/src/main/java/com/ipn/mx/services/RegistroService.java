package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.Registro;

public interface RegistroService {

	public List<Registro> findAll();
	public Registro findById(Long id);
	public Registro save (Registro tarea);
	public void delete(Long id);
	
}
