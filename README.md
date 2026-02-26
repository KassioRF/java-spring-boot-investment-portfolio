# Atividade Prática 03: API de Gerenciamento de Carteiro de Investimentos


Esta repositório implementa o serviço ``investments`` que é uma API que centraliza a visualização e o gerenciamento de diferentes tipos de ativos.


## Observações Gerais:

- O repositório contem a implementação da API e, portanto não integra interface gráfica.
- Foi adicionado seed  para povoar o banco de dados sempre que a aplicação e iniciada (via spring-boot).
  - [./seed/SeedDatabase.java](./investments/src/main/java/com/acme/financial/investments/seed/SeedDatabase.java)

- A API e o banco de dados (Postgres) rodam em containers, por meio do``docker-compose.yml`` localizado em [./docker/docker-compose.yml](./docker/docker-compose.yml). Para iniciar os serviços, execute o seguinte comando no diretório do [docker](./docker/):


### Comando para iniciar os serviços
```bash
docker compose --env-file .env.example up
```

### Consumindo a API

Exemplos de uso estão disponíveis no arquivo [./rest/routes.rest](./rest/routes.rest)


## Organização e Fluxo da Arquitetura

1. **Controller**  
   - Recebe requisições HTTP e valida payloads.
   - Chama os **UseCases** correspondentes.

2. **UseCase**  
   - Contém as regras de negócioda aplicação.  
   - Interage com o **Repository** e faz conversões ``DTO <-> Entidade`` usando **Converter**.  
   - Lança exceções customizadas se necessário.

3. **Repository**  
   - Responsável pelo acesso ao banco (JPA/Postgres).  
   - Fornece métodos CRUD e consultas específicas.

4. **Converter**  
   - Centraliza a conversão entre Entities e DTOs.  

5. **Seed**  
   - Popula a base de dados para testes ou desenvolvimento.  

6. **Config & Exception**  
   - Configurações gerais (ex: GlobalExceptionHandler, etc).  



## Endpoints implementados
1. **Cadastrar um novo ativo na carteira**

   * Endpoint: `POST /investments`
   * Payload:

     ```json
     {
       "type": "ACAO",
       "symbol": "BBAS3",
       "quantity": 100,
       "purchasePrice": 19.68,
       "purchaseDate": "2025-07-31"
     }
     ```

2. **Listar todos os ativos da carteira**

   * Endpoint: `GET /investments`

3. **Filtrar ativos por tipo**

   * Endpoint: `GET /investments?type=CRIPTO`

4. **Atualizar um ativo**

   * Endpoint: `PUT /investments/{id}`

5. **Remover um ativo da carteira**

   * Endpoint: `DELETE /investments/{id}`

6. **Resumo da carteira**

   * Endpoint: `GET /investments/summary`
   * Exemplo de resposta:

     ```json
     {
       "totalInvested": 15000.00,
       "totalByType": {
         "ACAO": 8000.00,
         "CRIPTO": 1000.00,
         "FUNDO": 6000.00
       },
       "assetCount": 5
     }
     ```
