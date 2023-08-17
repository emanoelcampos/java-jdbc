package dev.emanoel.modulo08.lojavirtual.view;

import dev.emanoel.modulo08.lojavirtual.controller.CategoryController;
import dev.emanoel.modulo08.lojavirtual.controller.ProductController;
import dev.emanoel.modulo08.lojavirtual.model.Category;
import dev.emanoel.modulo08.lojavirtual.model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductCategoryFrame extends  JFrame{

    private static final long serialVersionUID = 1L;

    private JLabel labelNome, labelDescricao, labelCategoria;
    private JTextField textoNome, textoDescricao;
    private JComboBox<Category> comboCategoria;
    private JButton botaoSalvar, botaoEditar, botaoLimpar, botarApagar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private ProductController productController;
    private CategoryController categoryController;

    public ProductCategoryFrame() {
        super("Produtos");
        Container container = getContentPane();
        setLayout(null);

        this.categoryController = new CategoryController();
        this.productController = new ProductController();

        labelNome = new JLabel("Nome do Produto");
        labelDescricao = new JLabel("Descrição do Produto");
        labelCategoria = new JLabel("Categoria do Produto");

        labelNome.setBounds(10, 10, 240, 15);
        labelDescricao.setBounds(10, 50, 240, 15);
        labelCategoria.setBounds(10, 90, 240, 15);

        labelNome.setForeground(Color.BLACK);
        labelDescricao.setForeground(Color.BLACK);
        labelCategoria.setForeground(Color.BLACK);

        container.add(labelNome);
        container.add(labelDescricao);
        container.add(labelCategoria);

        textoNome = new JTextField();
        textoDescricao = new JTextField();
        comboCategoria = new JComboBox<Category>();

        comboCategoria.addItem(new Category(0, "Selecione"));
        List<Category> categories = this.listCategory();
        for (Category category : categories) {
            comboCategoria.addItem(category);
        }

        textoNome.setBounds(10, 25, 265, 20);
        textoDescricao.setBounds(10, 65, 265, 20);
        comboCategoria.setBounds(10, 105, 265, 20);

        container.add(textoNome);
        container.add(textoDescricao);
        container.add(comboCategoria);

        botaoSalvar = new JButton("Salvar");
        botaoLimpar = new JButton("Limpar");

        botaoSalvar.setBounds(10, 145, 80, 20);
        botaoLimpar.setBounds(100, 145, 80, 20);

        container.add(botaoSalvar);
        container.add(botaoLimpar);

        tabela = new JTable();
        modelo = (DefaultTableModel) tabela.getModel();

        modelo.addColumn("Identificador do Produto");
        modelo.addColumn("Nome do Produto");
        modelo.addColumn("Descri��o do Produto");

        preencherTabela();

        tabela.setBounds(10, 185, 760, 300);
        container.add(tabela);

        botarApagar = new JButton("Excluir");
        botaoEditar = new JButton("Alterar");

        botarApagar.setBounds(10, 500, 80, 20);
        botaoEditar.setBounds(100, 500, 80, 20);

        container.add(botarApagar);
        container.add(botaoEditar);

        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                limparTabela();
                preencherTabela();
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean();
            }
        });

        botarApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
                limparTabela();
                preencherTabela();
            }
        });

        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                limparTabela();
                preencherTabela();
            }
        });
    }

    private void limparTabela() {
        modelo.getDataVector().clear();
    }

    private void update() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
            String descricao = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
            this.productController.update(nome, descricao, id);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void delete() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            this.productController.delete(id);
            modelo.removeRow(tabela.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Item exclu�do com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void preencherTabela() {
        java.util.List<Product> products = listarProduto();
        try {
            for (Product product : products) {
                modelo.addRow(new Object[] { product.getId(), product.getNome(), product.getDescricao() });
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private List<Category> listCategory() {
        return this.categoryController.list();
    }

    private void save() {
        if (!textoNome.getText().equals("") && !textoDescricao.getText().equals("")) {
            Product product = new Product(textoNome.getText(), textoDescricao.getText());
            Category category = (Category) comboCategoria.getSelectedItem();
            product.setCategoria_id(category.getId());
            this.productController.save(product);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            this.clean();
        } else {
            JOptionPane.showMessageDialog(this, "Nome e Descri��o devem ser informados.");
        }
    }

    private List<Product> listarProduto() {
        return this.productController.list();
    }

    private void clean() {
        this.textoNome.setText("");
        this.textoDescricao.setText("");
        this.comboCategoria.setSelectedIndex(0);
    }
}
