package dev.emanoel.modulo05.poolconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLServerConnection {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaConexao()) {
            System.out.printf("Connection established.");
        } catch (SQLException e) {
            System.out.printf("Error connection to the database.");
            e.printStackTrace();
        }
    }
}
