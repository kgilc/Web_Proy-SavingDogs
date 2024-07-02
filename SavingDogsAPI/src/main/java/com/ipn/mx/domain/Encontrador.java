package com.ipn.mx.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Encontrador")

public class Encontrador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncontrador;

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
	@Column (name = "idEncontrado", length = 100, nullable = false)
    private String idEncontrado;
	
}
