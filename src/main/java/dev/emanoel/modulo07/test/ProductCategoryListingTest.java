package dev.emanoel.modulo07.test;

import dev.emanoel.modulo05.poolconnection.ConnectionFactory;
import dev.emanoel.modulo07.dao.ProductCategoryDAO;
import dev.emanoel.modulo07.model.ProductCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductCategoryListingTest {

    public static void main(String[] args) throws SQLException {


        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recuperaConexao()) {
            ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO(connection);
            List<ProductCategory> categories = productCategoryDAO.listar();
            categories.stream().forEach(lpc -> System.out.println(lpc));
        }
    }
}
