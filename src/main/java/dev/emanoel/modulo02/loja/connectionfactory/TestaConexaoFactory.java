package dev.emanoel.modulo02.loja.connectionfactory;

import java.sql.*;

public class TestaConexaoFactory {

    public static void main(String[] args) {

        CriaConexao criaConexao = new CriaConexao();

        try (Connection connection = criaConexao.recuperaConexao()) {
            System.out.println("Connection established.");

            Statement statement = connection.createStatement();

            // execute retorna um booleano
            // true = lista (select) / false = diferente de lista(delete, update, insert)
            //boolean result = statement.execute("SELECT TOP (10) * FROM DimProduct");
            //System.out.println(result);

            statement.execute("SELECT TOP(10) ProductKey, ProductName, BrandName FROM DimProduct");
            ResultSet resultSet = statement.getResultSet();

            while(resultSet.next()) {
                Integer productKey = resultSet.getInt("ProductKey");
                System.out.println(productKey);

                String productName = resultSet.getString("ProductName");
                System.out.println(productName);

                String brandName = resultSet.getString("BrandName");
                System.out.println(brandName);

                System.out.println("--------------------------");

            }

        } catch (SQLException e) {
            System.out.println("Error connection to the database.");
            e.printStackTrace();
        }
    }
}
