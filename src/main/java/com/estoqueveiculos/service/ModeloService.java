package com.estoqueveiculos.service;

import com.estoqueveiculos.dto.ModeloDTO;
import com.estoqueveiculos.model.Marca;
import com.estoqueveiculos.model.Modelo;
import com.estoqueveiculos.repository.MarcaRepository;
import com.estoqueveiculos.repository.ModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    @Transactional
    public ModeloDTO criar(ModeloDTO dto) {
        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new IllegalArgumentException("Marca não encontrada com id: " + dto.getMarcaId()));
        Modelo modelo = Modelo.builder()
                .nome(dto.getNome())
                .marca(marca)
                .build();
        modelo = modeloRepository.save(modelo);
        return toDTO(modelo);
    }

    public List<ModeloDTO> listar() {
        return modeloRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ModeloDTO toDTO(Modelo modelo) {
        return ModeloDTO.builder()
                .id(modelo.getId())
                .nome(modelo.getNome())
                .marcaId(modelo.getMarca().getId())
                .build();
    }
}
