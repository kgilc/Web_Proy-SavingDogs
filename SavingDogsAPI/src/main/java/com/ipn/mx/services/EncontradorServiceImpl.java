package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.repository.EncontradorRepository;

@Service
public class EncontradorServiceImpl implements EncontradorService {
	
	@Autowired
	EncontradorRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public List<Encontrador> findAll() {
		return (List<Encontrador>) repository.findAll();
	}

	@Override
	public Encontrador findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Encontrador save(Encontrador encontrador) {
		return  repository.save(encontrador);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}


}
