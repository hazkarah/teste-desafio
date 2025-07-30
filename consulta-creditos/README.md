# Consulta Créditos

Este projeto utiliza Docker e Docker Compose para facilitar a execução dos serviços necessários.

## Tecnologias Utilizadas
- Docker
- Docker Compose
- Angular (Frontend)
- Spring Boot (Backend)
- PostgreSQL
- Kafka

## Estrutura da Solução
A solução é composta por dois principais módulos:
- **API:** Serviço backend desenvolvido em Spring Boot, responsável pelo processamento das regras de negócio e integração com banco de dados e Kafka.
- **APP:** Aplicação frontend desenvolvida em Angular, responsável pela interface com o usuário e comunicação com a API.

## Como executar a aplicação

1. **Pré-requisitos:**
   - Docker instalado
   - Docker Compose instalado

2. **Suba os containers:**
   No diretório raiz do projeto, execute o comando abaixo para construir e iniciar todos os serviços:

   ```sh
   docker compose up --build
   ```

   Este comando irá:
   - Construir as imagens do frontend e backend
   - Inicializar os serviços do banco de dados, Kafka, API e aplicação web

3. **Acessando a aplicação:**
   - Frontend: [http://localhost:8500](http://localhost:8500)
   - Backend (API): [http://localhost:8501](http://localhost:8501)
   - Documentação Swagger da API: [http://localhost:8501/swagger-ui.html](http://localhost:8501/swagger-ui.html)

4. **Parar os containers:**
   Para parar e remover os containers, execute:
   ```sh
   docker compose down
   ```

## Atenção às portas utilizadas

A aplicação utiliza as seguintes portas padrão:
- **Frontend (Angular):** 8500
- **Backend (API Spring Boot):** 8501

Certifique-se de que não há outros containers ou serviços utilizando as portas **8500** e **8501** antes de subir a aplicação. Caso haja conflito, ajuste as portas no arquivo `compose.yml` conforme necessário.


## Mensageria

A solução utiliza o Apache Kafka para comunicação assíncrona entre os serviços. O Kafka é responsável pelo processamento de eventos e integração entre sistemas.

- **Kafka UI:** Ferramenta para visualização e gerenciamento dos tópicos e mensagens do Kafka.
    - Acesse em: [http://localhost:8090](http://localhost:8090)


## Observações
- O arquivo `compose.yml` define todos os serviços necessários para o funcionamento do sistema.
- Logs da API podem ser encontrados em `/app/logs/application.log` dentro do container.

---

Para dúvidas ou problemas, consulte a documentação dos serviços ou abra uma issue.
