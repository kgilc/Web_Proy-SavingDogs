package com.ipn.mx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Propietario")

public class Propietario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpropietario;

    @Column (name = "nombre", length = 100, nullable = false)
    private String nombre;

	@Column (name = "ap", length = 100, nullable = false)
    private String ap;
	@Column (name = "am", length = 100, nullable = false)
    private String am;
	@Column (name = "correoPerdido", length = 100, nullable = false)
    private String correoPerdido;

	@Column (name = "correoEncontrado", length = 100, nullable = false)
    private String correoEncontrado;
	@Column (name = "idPerdido", length = 100, nullable = false)
    private Long idPerdido;
}