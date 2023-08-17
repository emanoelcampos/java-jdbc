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

    public void saveProduct(Product product) {
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveWithCategory(Product product) throws SQLException {
        String insertQuery = "INSERT INTO PRODUTO (NOME, DESCRICAO, CATEGORIA_ID) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getNome());
            preparedStatement.setString(2, product.getDescricao());
            preparedStatement.setInt(3, product.getCategoria_id());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    product.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Product> listProduct() {
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(Integer id) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct(String nome, String descricao, Integer id) {
       try {
           try (PreparedStatement preparedStatement = connection
                   .prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ? WHERE ID = ?")) {
               preparedStatement.setString(1, nome);
               preparedStatement.setString(2, descricao);
               preparedStatement.setInt(3, id);
               preparedStatement.execute();
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    private void trasformResultSetProduct(List<Product> products, PreparedStatement pstm) throws SQLException {
        try (ResultSet resultSet = pstm.getResultSet()) {
            while (resultSet.next()) {
                Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

                products.add(product);
            }
        }
    }

    public List<Product> searchProduct(Category category) throws SQLException {
        List<Product> products = new ArrayList<>();
        String selectQuery = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.execute();

            trasformResultSetProduct(products, preparedStatement);
        }
        return products;
    }
}
