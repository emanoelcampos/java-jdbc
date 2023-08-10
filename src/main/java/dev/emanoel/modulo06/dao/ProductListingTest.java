package dev.emanoel.modulo06.dao;

import dev.emanoel.modulo05.poolconnection.ConnectionFactory;
import dev.emanoel.modulo06.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductListingTest {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recuperaConexao()){
            ProductPersistence productPersistence = new ProductPersistence(connection);
            List<Product> listaProdutos = productPersistence.listar();
            listaProdutos.stream().forEach(lp -> System.out.println(lp));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
