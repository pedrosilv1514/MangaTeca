package Classes;
import java.util.*;
import javax.swing.ImageIcon;

public class Manga {
    protected String titulo;
    protected String sinopse;
    protected String autor;
    protected int estoque;
    protected double preço;
    protected ArrayList<Avaliacao> avaliacoes;
    protected Genero genero;
    protected ImageIcon imagem;
    
    public void Manga(){
        
    }
    public void AtualizarEstoque(int quantidade){
        /*
        provavelmente isso aqui devia ter só no adm
        */
    }
    public double CalcularMedia(ArrayList<Object> avaliacoes){
        return 0.00; //temporario
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

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
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

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }
    
    
}
