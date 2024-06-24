package com.ipn.mx.domain;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String tel;
    private String ubicacion;
}
