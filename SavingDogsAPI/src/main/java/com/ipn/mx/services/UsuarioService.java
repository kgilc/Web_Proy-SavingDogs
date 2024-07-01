package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save (Usuario tarea);
	public void delete(Long id);
    public Usuario login(String email, String password);

}
