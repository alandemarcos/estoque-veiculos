# Sistema Automotivo – Gestão de Estoque de Veículos

API REST em Java 17 + Spring Boot para gerenciamento de estoque de veículos de concessionária.

## Tecnologias

- Java 17
- Spring Boot 3.2
- Spring Web, Spring Data JPA
- MySQL
- Maven (wrapper incluído)
- Lombok
- SpringDoc OpenAPI (Swagger)

## Pré-requisitos

- Java 17+ (com `JAVA_HOME` configurado)
- MySQL 8+
- Maven opcional – o projeto inclui Maven Wrapper

## Configuração

1. Crie o banco de dados:

```sql
CREATE DATABASE estoque_veiculos;
```

2. Ajuste `application.properties` se necessário (usuário/senha do MySQL).

3. Execute a aplicação:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

4. Para compilar:

```bash
.\mvnw.cmd compile   # Windows
./mvnw compile       # Linux / macOS
```

## Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/marcas` | Criar marca |
| GET | `/marcas` | Listar marcas |
| POST | `/modelos` | Criar modelo |
| GET | `/modelos` | Listar modelos |
| POST | `/veiculos` | Criar veículo |
| GET | `/veiculos` | Listar/filtrar veículos |
| GET | `/veiculos/{id}` | Buscar veículo por ID |
| PUT | `/veiculos/{id}` | Atualizar veículo |
| DELETE | `/veiculos/{id}` | Excluir veículo |

### Filtros em GET /veiculos

- `marca` - Filtrar por marca
- `modelo` - Filtrar por modelo
- `ano` - Filtrar por ano
- `status` - DISPONIVEL, VENDIDO, RESERVADO
- `precoMin` - Preço mínimo
- `precoMax` - Preço máximo

## Swagger

Documentação interativa em: http://localhost:8080/swagger-ui.html

## Exemplo de requisição (criar veículo)

```bash
curl -X POST http://localhost:8080/veiculos \
  -H "Content-Type: application/json" \
  -d '{
    "marca": "Toyota",
    "modelo": "Corolla",
    "ano": 2022,
    "cor": "Prata",
    "preco": 120000,
    "quilometragem": 15000,
    "status": "DISPONIVEL"
  }'
```
Arquivo do frontend: /frontend/frontend.html

### Iniciar servidor de frontend

```bash 
python -m http.server 5500 -d frontend
```

###  Abrir Frontend no navegador:

http://localhost:5500

O arquivo `requests.http` contém exemplos prontos para uso no VS Code (extensão REST Client) ou em IDEs compatíveis.

Link do repositório: https://github.com/alandemarcos/estoque-veiculos
