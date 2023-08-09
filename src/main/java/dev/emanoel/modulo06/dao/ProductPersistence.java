package dev.emanoel.modulo06.dao;

import dev.emanoel.modulo06.model.Product;

import java.sql.*;

public class ProductPersistence {

    private Connection connection;

    public ProductPersistence(Connection connection) {
        this.connection = connection;
    }

    public void salvarProduto(Product product) throws SQLException {
        String sql = "INSERT INTO DimProduct(ProductName, BrandName, ColorName) VALUES(?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getBrandName());
            preparedStatement.setString(3, product.getColorName());
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()) {
                    product.setProductKey(resultSet.getInt(1));
                }
            }
        }
    }
}
