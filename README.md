# API REST com Spring Boot

Este projeto é uma API RESTful construída com Spring Boot, seguindo uma arquitetura baseada em camadas para organizar as responsabilidades do sistema. A aplicação permite operações básicas de CRUD (Create, Read, Update, Delete) e utiliza PostgreSQL para persistência dos dados.
- Também foi utilizado o Docker para criação da imagem para que fosse possível fazer o deploy do sistema na nuvem. [Acesse!](https://workshop-spring-jpa.fly.dev/)
## Arquitetura
Abaixo está um resumo da arquitetura:

![Arquitetura](https://github.com/user-attachments/assets/a24ecdc7-8492-4660-9da9-ce2969da3398)

1. **Client (Cliente)**: Interface utilizada pelo cliente para enviar requisições HTTP para a API, com métodos como `GET`, `POST`, `PUT` e `DELETE`. No exemplo da imagem, o cliente usa o Postman para realizar essas requisições.
2. **API (Camada My System)**: Ponto de entrada principal do sistema, onde as requisições são recebidas e tratadas.
3. **RestController**: Responsável por definir os endpoints da API e lidar com as requisições HTTP. Cada endpoint mapeia uma funcionalidade específica e direciona as chamadas para a camada de serviço.
4. **Service (Serviços)**: Camada intermediária que contém a lógica de negócios. Ela processa os dados recebidos do controller, realiza validações e manipulações necessárias e interage com o repositório.
5. **JPARepository (Persistência)**: Camada de persistência responsável por acessar o banco de dados PostgreSQL. Utiliza Spring Data JPA para simplificar operações de CRUD.
6. **Banco de Dados (PostgreSQL)**: Sistema de gerenciamento de banco de dados utilizado para armazenar os dados de forma estruturada.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para simplificação do desenvolvimento de aplicações Java.
- **Spring Data JPA**: Abstração de persistência que facilita a interação com o banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenamento de dados.
- Docker para containerização do sistema

## **Endpoints**

**USER**

- `GET` /users : Retorna todos os usuários cadastrados.
- `GET` /users/(id) : Retorna um usuário com base no id passado.
- `POST` /users : Adiciona um usuário com base nos dados passados no corpo da requisição.
- `PUT` /users/(id) : Altera as informações de um usuário com base nos dados passados no corpo da requisição.
- `DELETE` /users/(id) : Deleta um usuário com base no id passado caso ele não possua outras entidades que dependam dele.

**PRODUCT**

- `GET` /products : Retorna todos os produtos cadastrados.
- `GET` /products/(id) : Retorna um produto com base no id passado.
- `POST` /products : Adiciona um produto com base nos dados passados no corpo da requisição.
- `PUT` /products/(id) : Altera as informações de um produto com base nos dados passados no corpo da requisição.
- `DELETE` /products/(id) : Deleta um produto com base no id passado caso ele não possua outras entidades que dependam dele.

**ORDER**

- `GET` /orders : Retorna todos os pedidos cadastrados.
- `GET` /orders/(id) : Retorna um pedido com base no id passado.
- `POST` /orders : Adiciona um pedido com base nos dados passados no corpo da requisição.
- `PUT` /orders/(id) : Altera as informações de um pedido com base nos dados passados no corpo da requisição.
- `DELETE` /orders/(id) : Deleta um pedido com base no id passado caso ele não possua outras entidades que dependam dele.

**CATEGORY**

- `GET` /categories : Retorna todos as categorias cadastrados.
- `GET` /categories/(id) : Retorna uma categoria com base no id passado.
- `POST` /categories : Adiciona uma categoria com base nos dados passados no corpo da requisição.
- `PUT` /categories/(id) : Altera as informações de uma categoria com base nos dados passados no corpo da requisição.
- `DELETE` /categories/(id) : Deleta uma categoria com base no id passado caso ele não possua outras entidades que dependam dele. 

## Pré-requisitos

- **Java** 21 ou superior
- **Maven** para gerenciamento de dependências
- **PostgreSQL** para persistência de dados
- Ferramenta de teste de API como **Postman**
- Docker para executar como contâiner

## Git Clone 

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   OR
   git clone git@github.com:gui-motas/Spring-workshop-jpa.git
   ```
