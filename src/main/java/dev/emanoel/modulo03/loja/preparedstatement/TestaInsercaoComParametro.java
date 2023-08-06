package dev.emanoel.modulo03.loja.preparedstatement;

import dev.emanoel.modulo02.loja.connectionfactory.CriaConexao;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) {

        String nomeProduto = "Fone";
        String nomeMarca = "Baseus";
        String nomeCor = "Cinza";

        CriaConexao criaConexao = new CriaConexao();

        try(Connection connection = criaConexao.recuperaConexao()) {
            System.out.println("conexão ok.");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO DimProduct(ProductName, BrandName, ColorName) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,nomeProduto);
            statement.setString(2,nomeMarca);
            statement.setString(3,nomeCor);

            statement.execute();

            ResultSet resultSetKey = statement.getGeneratedKeys();
            while(resultSetKey.next()) {
                int id = resultSetKey.getInt(1);
                System.out.println(id);
            }
        } catch (SQLException e) {
            System.out.println("erro conexão.");
            e.printStackTrace();
        }
    }
}
