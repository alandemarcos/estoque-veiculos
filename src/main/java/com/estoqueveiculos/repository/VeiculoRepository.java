package com.estoqueveiculos.repository;

import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, JpaSpecificationExecutor<Veiculo> {
}
