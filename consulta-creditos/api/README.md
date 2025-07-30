# Consulta Créditos API

## Tecnologias Utilizadas
- **Spring Boot**: Framework principal para desenvolvimento da API.
- **Spring Data JPA**: Persistência e acesso a dados.
- **PostgreSQL**: Banco de dados relacional utilizado.
- **Apache Kafka**: Mensageria para integração de eventos.
- **Testcontainers**: Testes de integração com containers.
- **JUnit**: Framework de testes unitários e de integração.
- **Mockito**: Mocking para testes unitários.
- **OpenAPI/Swagger**: Documentação automática da API.
- **EditorConfig**: Padronização de estilos de código.
- Outros: Maven, Docker, etc.

## Execução do Projeto
1. **Pré-requisitos**:
   - Docker e Docker Compose instalados
   - Java 17+
   - Maven 3.8+

2. **Subir dependências**:
   - Execute o arquivo `compose.yml` (localizado na raiz do projeto):
     ```sh
     docker compose up -d
     ```

3. **Rodar a aplicação**:
   - Execute:
     ```sh
     ./mvnw spring-boot:run
     ```
   - Ou gere o JAR e execute:
     ```sh
     ./mvnw clean package
     java -jar target/consulta-creditos-0.0.1-SNAPSHOT.jar
     ```

## Testes
- Para rodar todos os testes (unitários e integração):
  ```sh
  ./mvnw verify
  ```
- Testes utilizam Testcontainers para simular dependências externas.

## OpenAPI
- A documentação da API está disponível via Swagger/OpenAPI em:
  - [Swagger UI](http://localhost:8080/swagger-ui/index.html)
  - [OpenAPI Docs](http://localhost:8080/v3/api-docs)

## Style e EditorConfig
- O projeto utiliza arquivo `.editorconfig` para padronização de estilos de código.
- Siga as convenções de formatação e boas práticas do projeto.

## Contribuição
1. Crie um branch para sua feature ou correção:
   ```sh
   git checkout -b minha-feature
   ```
2. Após implementar, abra um Merge Request (MR) ou Pull Request (PR) para revisão.
3. Siga o template de PR/MR e aguarde aprovação.

---

Dúvidas? Consulte a documentação interna ou abra uma issue.

