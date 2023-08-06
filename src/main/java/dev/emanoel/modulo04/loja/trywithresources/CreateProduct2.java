package dev.emanoel.modulo04.loja.trywithresources;

import dev.emanoel.modulo02.loja.connectionfactory.CriaConexao;

import java.sql.*;

public class CreateProduct2 {

    public static void main(String[] args) throws SQLException {

        CriaConexao criaConexao = new CriaConexao();
        try(Connection connection = criaConexao.recuperaConexao()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DimProduct(ProductName, ColorName) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                criaProduto("Teclado", "Logitech", preparedStatement);
                criaProduto("Mouse", "Logitech", preparedStatement);

                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Rollback foi executado.");
                connection.rollback();
            }
        }
    }

    private static void criaProduto(String nomeProduto, String corProduto, PreparedStatement preparedStatement) throws SQLException{

        preparedStatement.setString(1, nomeProduto);
        preparedStatement.setString(2, corProduto);

        /*if(nomeProduto.equals("Mouse")) {
            throw new RuntimeException("Não é possível adicionar o produto");
        }*/

        preparedStatement.execute();

        try(ResultSet resultSetKey = preparedStatement.getGeneratedKeys()) {
            while(resultSetKey.next()) {
                Integer id = resultSetKey.getInt(1);
                System.out.println(id);
            }
        }
    }
}
