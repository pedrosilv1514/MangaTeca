package Classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Classe que representa o produto principal do aplicativo, os mangás (quadrinhos orientais).

public class Manga {
    protected int id;
    protected String titulo;
    protected String sinopse;
    protected Genero genero;
    protected String autor;
    protected int estoque;
    protected double preco;
    protected ArrayList<Avaliacao> avaliacoes;
    protected String linkImagem;
    protected Status status;
    
    public Manga(){
        
    }
    
    public Manga(int id, String titulo, String sinopse, Genero genero, String autor, int estoque, double preco, ArrayList<Avaliacao> avaliacoes, String linkImagem){
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.autor = autor;
        this.estoque = estoque;
        this.preco = preco;
        this.id = id;
        this.linkImagem = linkImagem;
        this.avaliacoes = avaliacoes;
        this.genero = genero;
        this.status = Status.valueOf("DISPONIVEL");
    }
    
    // Novo construtor
    public Manga(int id, String titulo, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.status = Status.DISPONIVEL; // Valor padrão
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }
    
    public void atualizarEstoque(Manga manga, int novaQuantidade){
        String mangaEstoque= String.valueOf(manga.getId());
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";");
            String idManga = partes[0];
            if(idManga.equals(mangaEstoque)){
                partes[5] = String.valueOf(novaQuantidade);
                String mangasString = String.join(";", partes);
                linhasRestantes.add(mangasString);
            } else {
                linhasRestantes.add(linha);
            }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            for (String linhaRestante : linhasRestantes) {
                writer.write(linhaRestante);
                writer.newLine();
                writer.flush();
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    public double calcularMedia(ArrayList<Avaliacao> avaliacoes){
        int count = 0;
        int soma = 0;
        for(Avaliacao avaliacao : avaliacoes){
            count += 1;
            soma += avaliacao.getNota();
        }
        if(count == 0){
            return 0;
        } else {
            double resultado = soma/count;
            return resultado;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreço(double preço) {
        this.preco = preço;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero + ", autor=" + autor + ", estoque=" + estoque + ", preco=" + preco + ", avaliacoes=" + avaliacoes + ", linkImagem=" + linkImagem + "}";
    }
    
    
}
