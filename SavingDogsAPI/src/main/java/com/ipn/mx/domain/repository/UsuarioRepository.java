package com.ipn.mx.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
	
	 // Método para buscar un usuario por correo electrónico y contraseña
    Usuario findByCorreoAndPassword(String correo, String password);

}
