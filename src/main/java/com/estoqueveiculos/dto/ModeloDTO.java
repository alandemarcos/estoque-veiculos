package com.estoqueveiculos.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloDTO {

    private Long id;
    private String nome;
    private Long marcaId;
}
