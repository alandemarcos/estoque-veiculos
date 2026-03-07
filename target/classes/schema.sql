-- Script de criação do banco de dados
-- Execute manualmente: CREATE DATABASE estoque_veiculos;
-- O Hibernate com ddl-auto=update criará as tabelas automaticamente.
-- Este script serve como referência e pode ser usado para ambientes sem ddl-auto.

-- CREATE DATABASE IF NOT EXISTS estoque_veiculos;
-- USE estoque_veiculos;

CREATE TABLE IF NOT EXISTS marca (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS modelo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    marca_id BIGINT NOT NULL,
    FOREIGN KEY (marca_id) REFERENCES marca(id)
);

CREATE TABLE IF NOT EXISTS veiculo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(255) NOT NULL,
    preco DOUBLE NOT NULL,
    quilometragem INT NOT NULL,
    status VARCHAR(50) NOT NULL
);
