package br.unicap.edi.informacao;
public class Produto implements Comparable<Produto> {
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int estoque;
    public Produto(String codigo) {
        this.codigo = codigo;
    }
    public Produto(String codigo, String descricao, String fornecedor, double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public int compareTo(Produto data) {
        int result;
        result = this.getCodigo().compareToIgnoreCase(data.getCodigo());
        return result;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
