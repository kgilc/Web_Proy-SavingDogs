package com.ipn.mx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
	@Column (name = "nombre", length = 100, nullable = false)
    private String nombre;
	@Column (name = "correo", length = 100, nullable = false)
    private String correo;
	@Column (name = "telefono", length = 100, nullable = false)
    private String telefono;
	@Column (name = "ubicacion", length = 100, nullable = false)
    private String ubicacion;
}
