package dev.emanoel.modulo08.lojavirtual.dao;

import dev.emanoel.modulo08.lojavirtual.model.Category;

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

    public List<Category> listCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String selectQuery = "SELECT id, nome FROM categoria";

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    Category category = new Category(
                            resultSet.getInt(1),
                            resultSet.getString(2));
                    categories.add(category);
                }
            }
        }
        return categories;
    }
}
