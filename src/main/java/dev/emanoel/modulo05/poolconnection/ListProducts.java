package dev.emanoel.modulo05.poolconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListProducts {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperaConexao()) {
            System.out.println("conexão estabelecida!");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT TOP(10) ProductName, ColorName FROM DimProduct");
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                String produto = resultSet.getString("ProductName");
                System.out.println(produto);

                String cor = resultSet.getString("ColorName");
                System.out.println(cor);
            }
        } catch (SQLException e) {
            System.out.println("conexão falhou");
            e.printStackTrace();
        }
    }
}
