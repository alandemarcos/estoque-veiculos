package com.estoqueveiculos.repository;

import com.estoqueveiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
