# Conhecendo o JDBC

## Introdução

<img align="right" src="https://www.alura.com.br/artigos/assets/conhecendo-o-jdbc/jdbc.png" width="200">

Desenvolver uma aplicação Java do tipo desktop pode se tornar um desafio empolgante quando é necessário integrar a aplicação com um banco de dados MySQL local e um banco SQL Server em um servidor Windows.

A solução para esse cenário pode ser encontrada através da utilização dos recursos da API JDBC em linguagem Java.

Apesar da diversificação de soluções de dados no mercado, os bancos de dados relacionais ainda prevalecem. Portanto, ao criar sistemas, inevitavelmente, será necessário acessar bases de dados desse tipo. É nesse contexto que diversas linguagens de programação implementam mecanismos de acesso a dados.

## O que é JDBC?

A JDBC é uma API do Java que possibilita que uma aplicação construída na linguagem consiga acessar um banco de dados configurado local ou remotamente.

<div align="center" ><img src="https://www.alura.com.br/artigos/assets/conhecendo-o-jdbc/api-jdbc-conectada-a-um-banco-de-dados.png" width="300"></div>


## Componentes

A API JDBC é composta por dois componentes essenciais. O primeiro componente é constituído pelos pacotes (`Java.sql` e `Javax.sql`) que contêm classes e interfaces para padronizar a comunicação entre a aplicação Java e um banco de dados.

Outro elemento crucial são os drivers, responsáveis pela conexão e interação com bancos de dados específicos. Um driver JDBC é uma classe que implementa a interface `java.sql.Driver`. Muitos drivers são totalmente desenvolvidos em `Java`, permitindo um carregamento dinâmico.

Além disso, os drivers podem ser escritos de forma nativa, possibilitando o acesso a bibliotecas ou drivers de sistema que permitem a conexão com um banco de dados específico.

Para realizar a conexão com um banco, a classe `DriverManager` define um conjunto básico de operações e é responsável pela conexão inicial.

## Tipos de drivers


Os drivers JDBC são responsáveis por permitir que a aplicação Java execute comandos SQL em um banco de dados. Existem quatro tipos de drivers na arquitetura do JDBC:

- **Tipo 1**: JDBC-ODBC - Permite o acesso a drivers do tipo ODBC, um padrão estabelecido para o acesso a bancos de dados.

- **Tipo 2**: Implementa o protocolo proprietário do banco de dados, traduzindo as chamadas JDBC em chamadas específicas desse banco através de sua API proprietária.

- **Tipo 3**: Converte as chamadas JDBC em chamadas direcionadas para uma camada intermediária de software (middleware), que então faz a conversão para o protocolo do banco de dados.

- **Tipo 4**: Escritos puramente em Java, esses drivers implementam o protocolo proprietário do banco de dados, permitindo um desempenho superior ao acessar diretamente o Sistema Gerenciador de Banco de Dados (SGBD).

## Usando o JDBC

Podemos definir os seguintes passos para usar o JDBC:

1. Realizar o carregamento do driver do banco. `Class.forName("org.postgresql.Driver")`.

2. Criar a conexão com o banco. `DriverManager.getConnection(stringconexao,usuario,senha)`.

3. Preparar o comando a ser executado no banco. String `sql="SELECT * FROM alunos"`.

4. Executar o comando. Neste ponto, vale a pena ficarmos atentos: quando se trata de uma consulta, usamos `executeQuery`, quando se trata de um insert, update ou delete, usamos `executeUpdate`.

5. Tratar o resultado. Quando for o retorno de uma consulta (`ResultSet`), vamos iterar o objeto. Se for o retorno de `insert`, `update` ou `delete`, devemos avaliar o valor retornado.

## Conclusão

O JDBC é uma API poderosa para manipular base de dados, pois nos permite usar uma estrutura básica para conectar, além de interagir por meio do código Java em diversas fontes de dados, facilitando o trabalho de desenvolvedores Java. Os exemplos deste artigo têm como objetivo mostrar de maneira simples como utilizar a API.

