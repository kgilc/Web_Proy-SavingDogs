package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.perroPerdido;

public interface PerroPerdidoService {
	
	List<perroPerdido> findAll();
	perroPerdido findById(Long id);
	perroPerdido save (perroPerdido tarea);
	void delete(Long id);
    perroPerdido registroPerdido(perroPerdido perroperdido);
    List<perroPerdido> findByCorreo (String correo);
    //List<perroPerdido> findBycolorAndraza (String color, String raza);



	

}
