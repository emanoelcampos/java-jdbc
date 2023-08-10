package dev.emanoel.modulo06.test;

import dev.emanoel.modulo05.poolconnection.ConnectionFactory;
import dev.emanoel.modulo06.dao.ProductDAO;
import dev.emanoel.modulo06.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductListingTest {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recuperaConexao()){
            ProductDAO productDAO = new ProductDAO(connection);
            List<Product> listaProdutos = productDAO.listar();
            listaProdutos.stream().forEach(lp -> System.out.println(lp));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
