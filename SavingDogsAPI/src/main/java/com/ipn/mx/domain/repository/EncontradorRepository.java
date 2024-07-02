package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.Encontrador;
import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.Usuario;

public interface EncontradorRepository  extends CrudRepository<Encontrador,Long>{

    List<Encontrador> findBycorreoEncontrado(String correoEncontrado);

}
