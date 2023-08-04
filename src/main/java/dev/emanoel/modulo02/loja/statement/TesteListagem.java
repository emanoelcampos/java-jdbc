package dev.emanoel.modulo02.loja.statement;

import java.sql.*;

public class TesteListagem {

    public static void main(String[] args) {

        String connectionSring ="jdbc:sqlserver://localhost:1433;" +
                                "databaseName=ContosoRetailDW;" +
                                "user=sqlserver;password=12345;" +
                                "trustServerCertificate=true";

        try (Connection connection = DriverManager.getConnection(connectionSring)) {
            System.out.println("Connection established.");

            Statement statement = connection.createStatement();

            // execute retorna um booleano
            // true = lista (select) / false = diferente de lista(delete, update, insert)
            boolean result = statement.execute("SELECT TOP (10) * FROM DimProduct");
            System.out.println(result);


        } catch (SQLException e) {
            System.out.println("Error connection to the database.");
            e.printStackTrace();
        }
    }
}
