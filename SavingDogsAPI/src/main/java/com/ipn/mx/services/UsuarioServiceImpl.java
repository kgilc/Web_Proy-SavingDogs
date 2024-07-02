package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.Usuario;
import com.ipn.mx.domain.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario login(String email, String password) {
        return repository.findByCorreoAndPassword(email, password);
    }
}
