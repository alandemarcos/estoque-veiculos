package com.estoqueveiculos.service;

import com.estoqueveiculos.dto.VeiculoDTO;
import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.model.Veiculo;
import com.estoqueveiculos.repository.VeiculoRepository;
import com.estoqueveiculos.repository.VeiculoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Transactional
    public VeiculoDTO criar(VeiculoDTO dto) {
        Veiculo veiculo = toEntity(dto);
        veiculo = veiculoRepository.save(veiculo);
        return toDTO(veiculo);
    }

    public List<VeiculoDTO> listar(String marca, String modelo, Integer ano,
                                   StatusVeiculo status, Double precoMin, Double precoMax) {
        Specification<Veiculo> spec = Specification
                .where(VeiculoSpecification.comMarca(marca))
                .and(VeiculoSpecification.comModelo(modelo))
                .and(VeiculoSpecification.comAno(ano))
                .and(VeiculoSpecification.comStatus(status))
                .and(VeiculoSpecification.comPrecoMin(precoMin))
                .and(VeiculoSpecification.comPrecoMax(precoMax));
        return veiculoRepository.findAll(spec).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO buscarPorId(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado com id: " + id));
        return toDTO(veiculo);
    }

    @Transactional
    public VeiculoDTO atualizar(Long id, VeiculoDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado com id: " + id));
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
        veiculo.setCor(dto.getCor());
        veiculo.setPreco(dto.getPreco());
        veiculo.setQuilometragem(dto.getQuilometragem());
        veiculo.setStatus(dto.getStatus());
        veiculo = veiculoRepository.save(veiculo);
        return toDTO(veiculo);
    }

    @Transactional
    public void excluir(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new IllegalArgumentException("Veículo não encontrado com id: " + id);
        }
        veiculoRepository.deleteById(id);
    }

    private Veiculo toEntity(VeiculoDTO dto) {
        return Veiculo.builder()
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .ano(dto.getAno())
                .cor(dto.getCor())
                .preco(dto.getPreco())
                .quilometragem(dto.getQuilometragem())
                .status(dto.getStatus())
                .build();
    }

    private VeiculoDTO toDTO(Veiculo veiculo) {
        return VeiculoDTO.builder()
                .id(veiculo.getId())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .ano(veiculo.getAno())
                .cor(veiculo.getCor())
                .preco(veiculo.getPreco())
                .quilometragem(veiculo.getQuilometragem())
                .status(veiculo.getStatus())
                .build();
    }
}
