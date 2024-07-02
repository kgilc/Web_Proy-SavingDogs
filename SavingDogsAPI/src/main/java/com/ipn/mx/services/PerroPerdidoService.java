package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.perroPerdido;

public interface PerroPerdidoService {
	
	public List<perroPerdido> findAll();
	public perroPerdido findById(Long id);
	public perroPerdido save (perroPerdido tarea);
	public void delete(Long id);
    public perroPerdido registroPerdido(perroPerdido perroperdido);

	

}
