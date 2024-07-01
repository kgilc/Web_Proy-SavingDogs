package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.PerroEncontrado;

public interface PerroEncontradoService {
	
	public List<PerroEncontrado> findAll();
	public PerroEncontrado findById(Long id);
	public PerroEncontrado save (PerroEncontrado tarea);
	public void delete(Long id);
	

}
