package com.ipn.mx.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "perro_encontrado")
public class PerroEncontrado {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_encontrado;

    @Column(name = "raza", length = 100, nullable = false)
    private String raza;

    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;

    @Column(name = "color", length = 100, nullable = false)
    private String color;

    @Column(name = "car_esp", length = 255)
    private String carEsp;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "ap", length = 100, nullable = false)
    private String ap;

    @Column(name = "am", length = 100)
    private String am;

    @Column(name = "calle", length = 100, nullable = false)
    private String calle;

    @Column(name = "colonia", length = 100, nullable = false)
    private String colonia;

    @Column(name = "delegacion", length = 100, nullable = false)
    private String delegacion;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @Column(name = "cp", length = 10, nullable = false)
    private String cp;

    @Column(name = "foto", length = 1200, nullable = false)
    private String FotoFilePath;


}


