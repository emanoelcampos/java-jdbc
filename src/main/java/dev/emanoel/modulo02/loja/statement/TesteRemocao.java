package dev.emanoel.modulo02.loja.statement;

import dev.emanoel.modulo02.loja.connectionfactory.CriaConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

    public static void main(String[] args) {

        CriaConexao criaConexao = new CriaConexao();

        try(Connection connection = criaConexao.recuperaConexao()) {
            System.out.println("Conexão estabelecida.");

            Statement statement = connection.createStatement();
            statement.execute("DELETE DimProduct WHERE BrandName = 'Eroade'");

            int linhasModificadas = statement.getUpdateCount();
            System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);

        } catch (SQLException e) {
            System.out.println("Error ao conectar.");
            e.printStackTrace();
        }
    }
}
