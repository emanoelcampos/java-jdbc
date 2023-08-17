package dev.emanoel.modulo08.lojavirtual.dao;

import dev.emanoel.modulo08.lojavirtual.model.Category;
import dev.emanoel.modulo08.lojavirtual.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> listCategory() {
        try {
            List<Category> categories = new ArrayList<>();

            String selectQuery = "SELECT id, nome FROM categoria";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.execute();

                try (ResultSet resultSet = preparedStatement.getResultSet()) {
                    while (resultSet.next()) {
                        Category category = new Category(
                                resultSet.getInt(1),
                                resultSet.getString(2));
                        categories.add(category);
                    }
                }
            }
            return categories;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> listWithProduct() throws SQLException {
        Category last = null;
        List<Category> categories = new ArrayList<>();

        String selectQuery = "SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM categoria c INNER JOIN produto p ON c.id = p.categoria_id";

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    if(last == null || !last.getNome().equals(resultSet.getString(2))) {
                        Category category = new Category(
                                resultSet.getInt(1),
                                resultSet.getString(2));
                        last = category;
                        categories.add(category);
                    }
                    Product product = new Product(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                    last.addProduct(product);
                }
            }
        }
        return categories;
    }
}
