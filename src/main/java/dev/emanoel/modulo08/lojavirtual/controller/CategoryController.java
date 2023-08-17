package dev.emanoel.modulo08.lojavirtual.controller;

import dev.emanoel.modulo08.lojavirtual.dao.CategoryDAO;
import dev.emanoel.modulo08.lojavirtual.factory.ConnectionFactory;
import dev.emanoel.modulo08.lojavirtual.model.Category;

import java.sql.Connection;
import java.util.List;

public class CategoryController {

    private CategoryDAO categoryDAO;

    public CategoryController() {
        Connection connection = new ConnectionFactory().recoveryConnection();
        this.categoryDAO = new CategoryDAO(connection);
    }

    public List<Category> list() {
        return this.categoryDAO.listCategory();
    }
}
