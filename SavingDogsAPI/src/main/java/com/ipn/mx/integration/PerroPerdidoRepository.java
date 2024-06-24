package com.ipn.mx.integration;

import com.ipn.mx.domain.PerroPerdido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerroPerdidoRepository extends JpaRepository<PerroPerdido, Long> {
	
}