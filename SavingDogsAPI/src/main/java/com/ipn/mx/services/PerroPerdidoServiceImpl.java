package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.Usuario;
import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.domain.repository.PerroEncontradoRepository;
import com.ipn.mx.domain.repository.PerroPerdidoRepository;

@Service

public class PerroPerdidoServiceImpl implements PerroPerdidoService {
	
	 @Autowired
	    PerroEncontradoRepository encontradoRepository;

	    @Autowired
	    PerroPerdidoRepository perdidoRepository;
	
	@Override
	@Transactional(readOnly = false)
	public List<perroPerdido> findAll() {
		return (List<perroPerdido>) perdidoRepository.findAll();
	}

	@Override
	public perroPerdido findById(Long id) {
		return perdidoRepository.findById(id).orElse(null);
	}

	@Override
	public perroPerdido save(perroPerdido perroperdido) {
		return  perdidoRepository.save(perroperdido);
	}

	@Override
	public void delete(Long id) {
		perdidoRepository.deleteById(id);
	}
	
    @Override
    @Transactional
    public perroPerdido registroPerdido(perroPerdido perroperdido) {
        perroPerdido savedPerro = perdidoRepository.save(perroperdido);

        List<PerroEncontrado> perrosEncontrados = encontradoRepository.findByColorAndRaza(perroperdido.getColor(), perroperdido.getRaza());

        for (PerroEncontrado encontrado : perrosEncontrados) {
            Usuario contacto = new Usuario();
            contacto.setNombre(perroperdido.getNombre() + " " + perroperdido.getAp() + " " + perroperdido.getAm());
            contacto.setCorreo(perroperdido.getCorreo());
        }

        return savedPerro;
    }

}
