package com.ipn.mx.domain;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class PerroPerdido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raza;
    private String color;
    private String ubicacion;
    private String foto;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;
}