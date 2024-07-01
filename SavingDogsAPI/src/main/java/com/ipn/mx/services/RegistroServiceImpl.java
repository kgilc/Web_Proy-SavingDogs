package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.Registro;
import com.ipn.mx.domain.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements RegistroService {
	
	@Autowired
	RegistroRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public List<Registro> findAll() {
		return (List<Registro>) repository.findAll();
	}

	@Override
	public Registro findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Registro save(Registro propietario) {
		return  repository.save(propietario);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
