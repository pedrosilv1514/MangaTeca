package Classes;

import java.time.*;
import java.util.*;

public class teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        ArrayList<Manga> produtos = new ArrayList<>();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        Avaliacao avaliacao = new Avaliacao();
        Manga manga = new Manga("Jujutsu Kaisen", "itadori mata bixo", "Gege Akutami", 5, 24.4, 12);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Cartao cartao = new Cartao(123456789, 123, "25/10/2004");
        cliente.setNomeUsuario("Claudinho");
        cliente.setEmail("claudinhobochecha@gmail.com");
        cliente.setSenha("Tchubiraundaun");
        produtos.add(manga);
        carrinho.setTotal(24.4);
        carrinho.setProdutos(produtos);
        avaliacao.setNota(10);
        avaliacao.setComentario("uau");
        avaliacao.setData(LocalDate.of(2099, Month.JANUARY, 25));
        avaliacao.setCliente(cliente);
        avaliacao.setManga(manga);
        avaliacoes.add(avaliacao);
        cliente.setAvaliacoes(avaliacoes); 
        cliente.setCarrinhoCompras(carrinho);
        cliente.setCartao(cartao);
        cliente.setHistoricoCompras(produtos);
        UsuariosCSV.AdicionarUsuario(cliente);
        
    }
}
