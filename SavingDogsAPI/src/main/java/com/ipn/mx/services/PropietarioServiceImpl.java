package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.Propietario;
import com.ipn.mx.domain.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{
	
	@Autowired
	PropietarioRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public List<Propietario> findAll() {
		return (List<Propietario>) repository.findAll();
	}

	@Override
	public Propietario findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Propietario save(Propietario propietario) {
		return  repository.save(propietario);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Override
    public List<Propietario> findBycorreoPerdido (String correoPerdido) {
        return repository.findBycorreoPerdido (correoPerdido);
    }

}
