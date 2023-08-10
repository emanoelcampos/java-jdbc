package dev.emanoel.modulo06.dao;

import dev.emanoel.modulo06.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Product> listar() throws SQLException {
        List<Product> products= new ArrayList<>();

        String sql = "SELECT TOP(10) ProductKey, ProductName, BrandName, ColorName FROM DimProduct";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    Product product = new Product(resultSet.getInt("ProductKey"), resultSet.getString("ProductName"), resultSet.getString("BrandName"), resultSet.getString("ColorName"));
                    products.add(product);
                }
            }
        }
        return products;
    }
}
