package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.domain.repository.PerroPerdidoRepository;

@Service

public class PerroPerdidoServiceImpl implements PerroPerdidoService {
	
	@Autowired
	PerroPerdidoRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public List<perroPerdido> findAll() {
		return (List<perroPerdido>) repository.findAll();
	}

	@Override
	public perroPerdido findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public perroPerdido save(perroPerdido perroperdido) {
		return  repository.save(perroperdido);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
