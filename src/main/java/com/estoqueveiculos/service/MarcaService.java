package com.estoqueveiculos.service;

import com.estoqueveiculos.dto.MarcaDTO;
import com.estoqueveiculos.model.Marca;
import com.estoqueveiculos.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Transactional
    public MarcaDTO criar(MarcaDTO dto) {
        Marca marca = Marca.builder()
                .nome(dto.getNome())
                .build();
        marca = marcaRepository.save(marca);
        return toDTO(marca);
    }

    public List<MarcaDTO> listar() {
        return marcaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private MarcaDTO toDTO(Marca marca) {
        return MarcaDTO.builder()
                .id(marca.getId())
                .nome(marca.getNome())
                .build();
    }
}
