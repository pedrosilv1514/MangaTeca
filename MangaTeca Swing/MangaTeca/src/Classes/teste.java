package Classes;

import java.time.*;
import java.util.*;

public class teste {
    public static void main(String[] args) {
        ArrayList<Manga> produtos = new ArrayList<>();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        Avaliacao avaliacao = new Avaliacao(10, "muito bom", LocalDate.of(2024, Month.AUGUST, 24));
        Romance romance = new Romance("romance");
        Manga manga = new Manga(1, "Jujutsu Kaisen", "Nah i'd Win", romance, "Gege Akutami", 10, 29.99, avaliacoes, "https://m.media-amazon.com/images/I/81TmHlRleJL._AC_UF894,1000_QL80_.jpg");
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(24.99, produtos);
        produtos.add(manga);
        avaliacao.setManga(manga);
        avaliacoes.add(avaliacao);
        Cartao cartao = new Cartao(123456789, 123, "25/10/2004");
        Cliente cliente = new Cliente("Claudinho", "claudinhobochecha@gmail.com", "Tchubiraundaun", produtos, avaliacoes, carrinho, cartao);
        Sistema.AdicionarUsuario(cliente);
        
    }
}