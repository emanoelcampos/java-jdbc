package dev.emanoel.modulo05.poolconnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;database=ContosoRetailDW;trustServerCertificate=true");
        comboPooledDataSource.setUser("sqlserver");
        comboPooledDataSource.setPassword("12345");

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexao() throws SQLException {

        return this.dataSource.getConnection();
    }
}
