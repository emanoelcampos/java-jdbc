package dev.emanoel.modulo06.dao;

import dev.emanoel.modulo05.poolconnection.ConnectionFactory;
import dev.emanoel.modulo06.model.Product;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        Product product = new Product("Mouse", "Logitech", "Cinza");

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recuperaConexao()){
            ProductDAO productDAO = new ProductDAO(connection);
            productDAO.salvarProduto(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
