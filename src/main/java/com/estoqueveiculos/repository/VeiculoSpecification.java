package com.estoqueveiculos.repository;

import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.model.Veiculo;
import org.springframework.data.jpa.domain.Specification;

public final class VeiculoSpecification {

    private VeiculoSpecification() {
    }

    public static Specification<Veiculo> comMarca(String marca) {
        return (root, query, cb) -> marca == null || marca.isBlank()
                ? cb.conjunction()
                : cb.equal(cb.lower(root.get("marca")), marca.toLowerCase());
    }

    public static Specification<Veiculo> comModelo(String modelo) {
        return (root, query, cb) -> modelo == null || modelo.isBlank()
                ? cb.conjunction()
                : cb.equal(cb.lower(root.get("modelo")), modelo.toLowerCase());
    }

    public static Specification<Veiculo> comAno(Integer ano) {
        return (root, query, cb) -> ano == null
                ? cb.conjunction()
                : cb.equal(root.get("ano"), ano);
    }

    public static Specification<Veiculo> comStatus(StatusVeiculo status) {
        return (root, query, cb) -> status == null
                ? cb.conjunction()
                : cb.equal(root.get("status"), status);
    }

    public static Specification<Veiculo> comPrecoMin(Double precoMin) {
        return (root, query, cb) -> precoMin == null
                ? cb.conjunction()
                : cb.greaterThanOrEqualTo(root.get("preco"), precoMin);
    }

    public static Specification<Veiculo> comPrecoMax(Double precoMax) {
        return (root, query, cb) -> precoMax == null
                ? cb.conjunction()
                : cb.lessThanOrEqualTo(root.get("preco"), precoMax);
    }
}
