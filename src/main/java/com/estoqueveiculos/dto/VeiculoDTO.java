package com.estoqueveiculos.dto;

import com.estoqueveiculos.model.StatusVeiculo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeiculoDTO {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Double preco;
    private Integer quilometragem;
    private StatusVeiculo status;
}
