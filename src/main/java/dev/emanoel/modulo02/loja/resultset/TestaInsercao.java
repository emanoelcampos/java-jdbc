package dev.emanoel.modulo02.loja.resultset;

import dev.emanoel.modulo02.loja.connectionfactory.CriaConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) {

        CriaConexao criaConexao = new CriaConexao();

        try(Connection connection = criaConexao.recuperaConexao()) {
            System.out.println("Connection established.");
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO DimProduct (ProductName, BrandName, ColorName) VALUES ('Lanterna', 'Biking', 'Black')", Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSetKey = statement.getGeneratedKeys();

            while(resultSetKey.next()) {
                Integer productKey = resultSetKey.getInt(1);
                System.out.println("O ProductKey criado foi: " + productKey);
            }

        } catch (SQLException e) {
            System.out.println("Error connection to the database.");
            e.printStackTrace();
        }
    }
}
