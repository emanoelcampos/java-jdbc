package dev.emanoel.modulo08.lojavirtual.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private final DataSource dataSource;

    public ConnectionFactory () {
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;database=loja_virtual;trustServerCertificate=true");
        pooledDataSource.setUser("sqlserver");
        pooledDataSource.setPassword("12345");

        this.dataSource = pooledDataSource;
    }

    public Connection recoveryConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
