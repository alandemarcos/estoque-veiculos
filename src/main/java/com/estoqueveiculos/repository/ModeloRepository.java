package com.estoqueveiculos.repository;

import com.estoqueveiculos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
