package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.repository.PerroEncontradoRepository;

@Service

public class PerroEncontradoServiceImpl implements PerroEncontradoService {
	
	@Autowired
	PerroEncontradoRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public List<PerroEncontrado> findAll() {
		return (List<PerroEncontrado>) repository.findAll();
	}

	@Override
	public PerroEncontrado findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public PerroEncontrado save(PerroEncontrado perroencontrado) {
		return  repository.save(perroencontrado);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
