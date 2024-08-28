package Classes;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Administrador extends Usuario {
    protected RelatorioDeVendas relatorioDeVendas;
    
    public Administrador(String NomeUsuario, String email, String senha){
    Cadastrar(NomeUsuario, email, senha);
    }
    
    public void adicionarManga(Manga manga){
        try {
            //Verificar se o arquivo existe
            boolean existe = new File("./dados/Mangas.csv").exists();
            
            //Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter("./dados/Mangas.csv", StandardCharsets.ISO_8859_1, existe);
            
            if (!existe) {
                writer.write("Id;Titulo;Sinopse;Gênero;Autor;Estoque;Preco;Avaliacoes;Imagem\n");
            }
            
            //Escrever os dados do mangá no formato certo
                writer.write(manga.getId() + ";" + manga.getTitulo() + ";" + manga.getSinopse() + ";" + manga.getGenero() + ";" + manga.getAutor() + ";" + manga.getEstoque() + ";" + manga.getPreco() + ";" + manga.getAvaliacoes() + ";" + manga.getLinkImagem() + "\n");
                writer.flush();
                writer.close();  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarManga(Manga manga){
        
    }
    public void removerManga(Manga manga){
        
    }
    public void atualizarEstoque(Manga manga, int novaQuantidade){
        
    }
    public void moderarAvaliacao(Avaliacao avaliacao){
        
    }
    public RelatorioDeVendas gerarRelatorioDeVendas(){
        return relatorioDeVendas; //temporario
    }

    public RelatorioDeVendas getRelatorioDeVendas() {
        return relatorioDeVendas;
    }

    public void setRelatorioDeVendas(RelatorioDeVendas relatorioDeVendas) {
        this.relatorioDeVendas = relatorioDeVendas;
    }
    
}
