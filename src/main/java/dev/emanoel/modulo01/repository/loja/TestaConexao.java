package dev.emanoel.modulo01.repository.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) {

        String connectionSring = "jdbc:sqlserver://localhost:1433;databaseName=ContosoRetailDW;user=sqlserver;password=12345;trustServerCertificate=true";

        try{
            try (Connection connection = DriverManager.getConnection(connectionSring)) {
                System.out.printf("Connection established.");
            }
        } catch (SQLException e) {
            System.out.printf("Error connection to the database.");
            e.printStackTrace();
        }

    }

}
