package com.ipn.mx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InformacionUsuarioDTO {
    private String nombre;
    private List<PerroEncontrado> perrosEncontrados;
    private List<perroPerdido> perrosPerdidos;
}
