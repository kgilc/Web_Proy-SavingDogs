package com.ipn.mx.domain;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "perro_perdido")
public class perroPerdido {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perdido;
	@Column (name = "raza", length = 100, nullable = false)
    private String raza;
	@Column (name = "color", length = 100, nullable = false)
    private String color;
	@Column (name = "ubicacion", length = 100, nullable = false)
    private String ubicacion;
	@Column (name = "foto", length = 1200, nullable = false)
    private String foto;
	@ManyToOne
    @JoinColumn(name = "id_registro", referencedColumnName = "id_registro", nullable = false)
    private Registro registro;
	@ManyToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "idPropietario", nullable = false)
    private Propietario propietario;
}

