# 📚 Terceiro Challenge - Oracle Next Education (ONE)

Bem-vindo ao LiterAlura! Este desafio propõe a construção de um catálogo de livros interativo, onde você irá consumir dados de uma API de livros, manipular as informações em JSON, armazená-las em um banco de dados e apresentar opções de consulta e filtragem via console. O projeto faz parte do programa de aprendizado do ONE (Oracle Next Education) e visa consolidar práticas fundamentais de desenvolvimento em Java e Spring Boot.

---

## 📜 Descrição do Projeto

A aplicação permite ao usuário interagir via console, oferecendo pelo menos 5 opções distintas de manipulação do catálogo de livros. Os dados dos livros são obtidos dinamicamente a partir de uma API, processados em JSON, armazenados e consultados em um banco de dados PostgreSQL, e apresentados de forma clara e acessível.

### Principais funcionalidades

- **Menu interativo** com no mínimo 5 opções para interação com o catálogo.
- **Consumo de API de livros** para obter títulos, autores e demais informações em tempo real.
- **Análise e manipulação de JSON** utilizando biblioteca apropriada.
- **Armazenamento e consulta em banco de dados PostgreSQL** utilizando JPA.
- **Exibição e filtragem dos resultados** no console, permitindo buscas por autor, título, etc.

---

## 🏗️ Arquitetura e Design

O projeto utiliza o framework **Spring Boot**, com execução via **CommandLineRunner** para interação diretamente no console. O acesso ao banco de dados é realizado por meio do **Spring Data JPA**, garantindo persistência eficiente e consultas flexíveis. A manipulação das respostas da API é feita por meio de uma biblioteca JSON (como Gson ou Jackson).

**Principais pontos da arquitetura:**
- Estruturação em camadas (controller, service, repository).
- Entidades mapeadas com JPA.
- Uso de repositórios para persistência e consulta.
- Injeção de dependências do Spring para facilitar testes e manutenção.
- Execução do fluxo principal via CommandLineRunner.

---

## 🛠️ Funcionalidades

✅ **Menu Interativo**
- O usuário pode escolher facilmente entre as opções disponíveis para consultar ou manipular o catálogo.

✅ **Consumo de API**
- As informações dos livros são buscadas em tempo real a partir de uma API específica.

✅ **Manipulação de JSON**
- Dados recebidos em formato JSON são processados e convertidos em objetos Java.

✅ **Persistência em Banco de Dados PostgreSQL com JPA**
- Livros e autores são armazenados em um banco relacional, permitindo consultas futuras sem necessidade de nova requisição à API.

✅ **Consulta e Filtros**
- O usuário pode listar livros, buscar por autor, título, ou exibir detalhes específicos com facilidade.

---

## 🚀 Tecnologias Utilizadas

- **Java**: Lógica principal da aplicação.
- **Spring Boot**: Framework para desenvolvimento ágil e produtivo.
- **Spring Data JPA**: Persistência e acesso ao banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado.
- **Jackson**: Biblioteca para análise e manipulação de JSON.
- **CommandLineRunner**: Execução de comandos e menus via console.
- **API de Livros - [Gutendex](https://gutendex.com/)**: Fonte dos dados de livros e autores (especificada no backlog do desafio).

---

## 🔧 Como executar o projeto?

1. **Clone este repositório em sua máquina:**
```sh
git clone https://github.com/MrClaro/challenge-literalura.git
```

2. **Configure o banco de dados PostgreSQL:**
- Crie um banco para o projeto (ex: `literalura`)
- Atualize as configurações do banco em `src/main/resources/application.properties`:
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Execute o projeto:**
- Via terminal:
    ```sh
    ./mvnw spring-boot:run
    ```
    ou
    ```sh
    mvn spring-boot:run
    ```
- Ou importe como projeto Maven/Spring Boot em sua IDE favorita e execute a classe principal (`@SpringBootApplication`).

4. **Siga as instruções exibidas no console para interagir com o catálogo de livros.**

---

## 🏆 Desafio do Programa ONE

Este projeto é o terceiro desafio do programa Oracle Next Education e foi desenhado para consolidar conhecimentos em:

- Consumo de APIs externas e manipulação de dados JSON.
- Persistência de dados em banco relacional com JPA.
- Estruturação de menus interativos via console.
- Boas práticas de validação e exibição de dados para o usuário.
- Arquitetura limpa e reutilizável com Spring Boot.

---

## 🤝 Contribuição

Sugestões de melhorias e pull requests são sempre bem-vindos! Sinta-se livre para contribuir com o projeto e ajudar outros desenvolvedores da comunidade. 😊

---

## 📄 Licença

Este projeto foi desenvolvido como parte de um programa educacional e está livre para uso pessoal e educacional.
