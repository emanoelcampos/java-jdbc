# Java e JDBC: trabalhando com um banco de dados

Este repositório é dedicado ao segundo curso da formação de Java e SpringBoot oferecido pela Alura em colaboração com o programa One da Oracle. Durante o curso, adquiri conhecimentos sobre o pacote `JDBC` e os fundamentos essenciais dessa linguagem de programação.

<div align="center" ><img src="https://github.com/emanoelcampos/programa-one-oracle/assets/68448029/ab736b12-62a0-4f05-90e0-380d5e756c41" width="400"></div>

## Os assuntos abordados no curso incluem:

O curso foi dividido em diversos módulos, cada um com seus respectivos exercícios, atividades e um desafio durante o curso.

<img align="right" src="https://github.com/emanoelcampos/programa-one-oracle/assets/68448029/7bf8aed1-0c01-44a8-97e1-fd084f77682a" width="120">

- JDBC, incluindo a necessidade de um driver JDBC, a definição de JDBC como Java Database Connectivity, e como abrir uma conexão usando o método `getConnection` da classe `DriverManager`.
- Simplificar a criação de conexões usando a classe `ConnectionFactory`, como executar comandos SQL com a interface `java.sql.Statement`, e os riscos de segurança relacionados ao SQL Injection.
- Evitar o SQL Injection usando a interface `PreparedStatement` e discutimos o conceito de transações no banco de dados, incluindo o uso de `commit` e `rollback`.
- Uso de pools de conexão, gerenciados pela interface `javax.sql.DataSource`, com uma menção ao C3PO como uma implementação de pool de conexão.
- Padrão ``Data Access Object (DAO)`` e como encapsular as operações `JDBC` relacionadas a domínio em classes `DAO`.
- Discutimos a otimização de consultas usando `joins SQL` e a importância de criar nossa própria camada de persistência.
- Exploramos a estrutura em camadas de uma aplicação, com foco na camada de persistência, e a importância de evitar o vazamento de detalhes de implementação.
- Enfatizamos a estrutura de camadas em uma aplicação, mencionando as camadas clássicas e o fluxo entre elas, além de destacar que o curso se concentra na camada de persistência, com uma referência a outras formações que abordarão a criação da view ou front-end para Android ou web.

## Minha jornada

Este repositório é um registro de todo o meu avanço no curso. Ao longo do curso, tive a oportunidade de aplicar esses conceitos através de exercícios e atividades práticas. Nesse repositório, você encontrará os exercícios, atividades e desafios realizados por mim durante o curso e todos eles estão organizados por módulo e podem ser encontrados em suas respectivas pastas.
