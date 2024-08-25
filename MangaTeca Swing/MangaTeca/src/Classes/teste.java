package Classes;

import java.time.*;
import java.util.*;

public class teste {
    public static void main(String[] args) {
        ArrayList<Manga> produtos = new ArrayList<>();
        ArrayList<Avaliacao> avaliacoesComedia = new ArrayList<>();
        ArrayList<Avaliacao> avaliacoesAcao = new ArrayList<>();
        Romance romance = new Romance("romance");
        Acao acao = new Acao("acao");
        Comedia comedia = new Comedia("comedia");
        
        Administrador admin = new Administrador("Admin","Admin@gmail.com","Adm123");
        Avaliacao avaliacao = new Avaliacao(10, "Muito bom morri de rir", LocalDate.of(2024, Month.AUGUST, 24));
        Avaliacao avaliacao2 = new Avaliacao(7, "You are my special", LocalDate.of(2024, Month.AUGUST, 25));
        Avaliacao avaliacao3 = new Avaliacao(5, "Superestimado.", LocalDate.of(2024, Month.AUGUST, 24));
        Manga manga = new Manga(1, "Azumanga Daioh!", "Osaka", comedia, "Kiyohiko Azuma", 10, 16.99, avaliacoesComedia, "https://cdn.myanimelist.net/images/manga/2/259651.jpg");
        Manga manga2 = new Manga(2, "Jujutsu Kaisen", "Itadori", acao, "Gege Akutami", 7, 29.99, avaliacoesAcao, "https://cdn.myanimelist.net/images/manga/3/210341l.jpg");
        
        produtos.add(manga);
        produtos.add(manga2);
        
        avaliacao.setManga(manga.getTitulo());
        avaliacao2.setManga(manga2.getTitulo());
        avaliacoesComedia.add(avaliacao);
        avaliacoesAcao.add(avaliacao2);
        avaliacoesAcao.add(avaliacao3);
        
        Cliente cliente = new Cliente("Eduardo", "eduardopsousa28@gmail.com", "MrBombastic.2024", produtos, avaliacoesAcao, new CarrinhoDeCompras(45.98, produtos), new Cartao(123456789, 123, "25/10/2004"));
        avaliacao.setCliente(cliente);
        Cliente cliente2 = new Cliente("Pedro", "pedrinreidelas@gmail.com", "MikeMaluco.2024", produtos, avaliacoesComedia, new CarrinhoDeCompras(45.98, produtos), new Cartao(987654321, 321, "28/10/2005"));
        avaliacao2.setCliente(cliente2);
        
        //Sistema.AdicionarUsuario(admin);
        //Sistema.AdicionarUsuario(cliente);
        //Sistema.AdicionarUsuario(cliente2);
        //Sistema.AdicionarManga(manga);
        //Sistema.AdicionarManga(manga2);
        Sistema.ListarMangas();
        
    }
}
