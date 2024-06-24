package com.ipn.mx.domain;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}