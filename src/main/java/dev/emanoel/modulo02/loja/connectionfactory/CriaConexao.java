package dev.emanoel.modulo02.loja.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

    public Connection recuperaConexao() throws SQLException {

        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ContosoRetailDW;user=sqlserver;password=12345;trustServerCertificate=true");
    }
}
