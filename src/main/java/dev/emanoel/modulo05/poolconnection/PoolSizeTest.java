package dev.emanoel.modulo05.poolconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolSizeTest {

    public static void main(String[] args) throws SQLException {

        PoolSizeConnection poolSizeConnection = new PoolSizeConnection();

        for(int i = 1; i <= 20; i++) {
            poolSizeConnection.recuperaConexao();
            System.out.println("conexão de número: " + i);
        }
    }
}
