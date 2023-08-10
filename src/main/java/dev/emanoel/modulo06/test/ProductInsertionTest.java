package dev.emanoel.modulo06.test;

import dev.emanoel.modulo05.poolconnection.ConnectionFactory;
import dev.emanoel.modulo06.model.Product;

import javax.xml.transform.Result;
import java.sql.*;

public class ProductInsertionTest {

    public static void main(String[] args) {

        Product mouse = new Product("Mouse", "Logitech", "Cinza");

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperaConexao()){
            String sql = "INSERT INTO DimProduct(ProductName, BrandName, ColorName) VALUES(?, ?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, mouse.getProductName());
                preparedStatement.setString(2, mouse.getBrandName());
                preparedStatement.setString(3, mouse.getColorName());
                preparedStatement.execute();

                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    while(resultSet.next()) {
                        mouse.setProductKey(resultSet.getInt(1));
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(mouse);
    }
}
