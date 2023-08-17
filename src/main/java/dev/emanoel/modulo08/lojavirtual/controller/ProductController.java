package dev.emanoel.modulo08.lojavirtual.controller;

import dev.emanoel.modulo08.lojavirtual.dao.CategoryDAO;
import dev.emanoel.modulo08.lojavirtual.dao.ProductDAO;
import dev.emanoel.modulo08.lojavirtual.factory.ConnectionFactory;
import dev.emanoel.modulo08.lojavirtual.model.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private ProductDAO productDAO;

    public ProductController() {
        Connection connection = new ConnectionFactory().recoveryConnection();
        this.productDAO = new ProductDAO(connection);
    }

    public void delete(Integer id) {
        this.productDAO.deleteProduct(id);
    }

    public void save(Product product) {
        this.productDAO.saveProduct(product);
    }

    public List<Product> list() {
        return this.productDAO.listProduct();
    }

    public void update(String nome, String descricao, Integer id) {
        this.productDAO.updateProduct(nome, descricao, id);
    }
}
