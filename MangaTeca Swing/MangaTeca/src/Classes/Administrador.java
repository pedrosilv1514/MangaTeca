package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Administrador extends Usuario {
    protected RelatorioDeVendas relatorioDeVendas;

    // Construtor que chama o construtor da classe pai (Usuario)
    public Administrador(String NomeUsuario, String email, String senha) {
        super(NomeUsuario); // Chama o construtor da classe Usuario
        this.email = email;
        this.senha = senha;
        Cadastrar(NomeUsuario, email, senha);
    }

    // Construtor vazio, caso precise instanciar sem argumentos
    public Administrador() {
        super(""); // Chama o construtor da classe Usuario com um valor vazio
    }

    public void adicionarManga(Manga manga) {
        try {
            // Verificar se o arquivo existe
            boolean existe = new File("./dados/Mangas.csv").exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter("./dados/Mangas.csv", StandardCharsets.ISO_8859_1, existe);

            if (!existe) {
                writer.write("Id;Titulo;Sinopse;Gênero;Autor;Estoque;Preco;Avaliacoes;Imagem\n");
            }

            // Escrever os dados do mangá no formato certo
            writer.write(manga.getId() + ";" + manga.getTitulo() + ";" + manga.getSinopse() + ";" + manga.getGenero() + ";" + manga.getAutor() + ";" + manga.getEstoque() + ";" + manga.getPreco() + ";" + manga.getAvaliacoes() + ";" + manga.getLinkImagem() + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarManga(Manga manga, Manga mangaAtualizado){
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String IdManga = partes[0];
                System.out.println(IdManga);
                if(IdManga.equals(String.valueOf(manga.getId()))){
                    String mangaNovo = mangaAtualizado.getId() + ";" + mangaAtualizado.getTitulo() + ";" + mangaAtualizado.getSinopse() + ";" + mangaAtualizado.getGenero() + ";" + mangaAtualizado.getAutor() + ";" + mangaAtualizado.getEstoque() + ";" + mangaAtualizado.getPreco() + ";" + mangaAtualizado.getAvaliacoes() + ";" + mangaAtualizado.getLinkImagem();
                    linhasRestantes.add(mangaNovo);
                } else {
                    linhasRestantes.add(linha);
                }
            }
            reader.close();
        } catch (IOException e){
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
    
    public void removerManga(Manga manga){
        String mangaPraRemover = String.valueOf(manga.getId());
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String IdManga = partes[0];

                if (!IdManga.equals(mangaPraRemover)) {
                    linhasRestantes.add(linha);
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            for (String linhaRestante : linhasRestantes) {
                writer.write(linhaRestante);
                System.out.println(linhaRestante);
                writer.newLine();
                writer.flush();
                
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
