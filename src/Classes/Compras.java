package Classes;

import java.time.LocalDate;

public class Compras {
    protected int id;
    protected String nomeManga;
    protected int quantidade;
    protected LocalDate data;
    protected double preco;  // Adiciona o atributo preco

    // Atualiza o construtor para aceitar o novo parâmetro preco
    public Compras(int id, String nomeManga, int quantidade, LocalDate data, double preco) {
        this.id = id;
        this.nomeManga = nomeManga;
        this.quantidade = quantidade;
        this.data = data;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeManga() {
        return nomeManga;
    }

    public void setNomeManga(String nomeManga) {
        this.nomeManga = nomeManga;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", nomeManga=" + nomeManga + ", quantidade=" + quantidade + ", data=" + data + ", preco=" + preco + '}';
    }
}
