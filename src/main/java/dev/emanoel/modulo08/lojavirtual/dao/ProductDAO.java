package dev.emanoel.modulo08.lojavirtual.dao;

import dev.emanoel.modulo08.lojavirtual.model.Category;
import dev.emanoel.modulo08.lojavirtual.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveProduct(Product product) throws SQLException {
        String insertQuery = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getNome());
            preparedStatement.setString(2, product.getDescricao());
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while(resultSet.next()) {
                    product.setId(resultSet.getInt(1));
                }
            }
        }

    }

    public List<Product> listProduct() throws SQLException {
        List<Product> products= new ArrayList<>();

        String selectQuery = "SELECT id, nome, descricao, categoria_id FROM produto";

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4));
                    products.add(product);
                }
            }
        }
        return products;
    }

    public List<Product> searchByCategory(Category category) throws SQLException {
        List<Product> products = new ArrayList<>();

        String selectWhereQuery = "SELECT id, nome, descricao FROM produto WHERE categoria_id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectWhereQuery)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    products.add(product);
                }
            }
        }
        return products;
    }
}
