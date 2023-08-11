package dev.emanoel.modulo08.lojavirtual.model;

public class Product {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer categoria_id;

    public Product(Integer id, String nome, String descricao, Integer categoria_id) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria_id = categoria_id;
    }

    public Product(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Product(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return String.format("Os produtos são: %d, %s, %s, %s",
                this.id, this.nome, this.descricao, this.categoria_id);
    }
}
