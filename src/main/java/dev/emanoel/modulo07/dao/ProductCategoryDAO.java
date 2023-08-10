package dev.emanoel.modulo07.dao;

import dev.emanoel.modulo07.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDAO {

    private Connection connection;

    public ProductCategoryDAO(Connection connection) {
         this.connection = connection;
    }

    public List<ProductCategory> listar() throws SQLException {
        List<ProductCategory> categories = new ArrayList<>();

        String sql = "SELECT ProductCategoryKey, ProductCategoryLabel, ProductCategoryName FROM DimProductCategory";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()) {
                    ProductCategory productCategory = new ProductCategory(
                            resultSet.getInt("ProductCategoryKey"),
                            resultSet.getString("ProductCategoryLabel"),
                            resultSet.getString("ProductCategoryName"));
                    categories.add(productCategory);
                }
            }
        }
        return categories;
    }
}
