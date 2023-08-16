package dev.emanoel.modulo08.lojavirtual.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private Integer id;
    private String nome;
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return String.format("As categorias são: %d, %s",
                this.id, this.nome);
    }
}
