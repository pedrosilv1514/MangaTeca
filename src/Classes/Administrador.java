package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Classe que repesenta o Administrador do sistema, capaz de gerenciar os mangás.

public class Administrador extends Usuario {

    // Construtor que chama o construtor da classe pai (Usuario)
    public Administrador(String NomeUsuario, String email, String senha) {
        super(NomeUsuario);
        this.setEmail(email);
        this.setSenha(senha);
        Cadastrar(NomeUsuario, email, senha); //Método da classe pai que insere o administrador no CSV.
    }

    // Construtor vazio, caso precise instanciar sem argumentos
    public Administrador() {
        super(); // Chama o construtor da classe Usuario com um valor vazio
    }

    public void adicionarManga(Manga manga) {
        try {
            // Verificar se o arquivo existe
            boolean existe = new File("./dados/Mangas.csv").exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter("./dados/Mangas.csv", StandardCharsets.ISO_8859_1, existe);

            if (!existe) {
                //Se o arquivo CSV dos mangás não existir, será criado um novo com o cabeçalho abaixo.
                writer.write("Id;Titulo;Sinopse;Gênero;Autor;Estoque;Preco;Avaliacoes;Imagem;Status\n");
            }

            // Escrever os dados do mangá no formato certo
            writer.write(manga.getId() + ";" + manga.getTitulo() + ";" + manga.getSinopse() + ";" + manga.getGenero() + ";" + manga.getAutor() + ";" + manga.getEstoque() + ";" + manga.getPreco() + ";" + manga.getAvaliacoes() + ";" + manga.getLinkImagem() +  ";" + manga.getStatus() + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarManga(Manga manga, Manga mangaAtualizado){
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>(); //Arraylist que vai armazenar as linhas do CSV para reescrevê-lo ao final da execução da função.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String IdManga = partes[0];
                if(IdManga.equals(String.valueOf(manga.getId()))){
                    String mangaNovo = mangaAtualizado.getId() + ";" + mangaAtualizado.getTitulo() + ";" + mangaAtualizado.getSinopse() + ";" + mangaAtualizado.getGenero() + ";" + mangaAtualizado.getAutor() + ";" + mangaAtualizado.getEstoque() + ";" + mangaAtualizado.getPreco() + ";" + mangaAtualizado.getAvaliacoes() + ";" + mangaAtualizado.getLinkImagem() + ";" + mangaAtualizado.getStatus();
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
            //Reescrever o arquivo com o mangá atualizado, mantendo a ordem de IDs original.
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
        String mangaParaRemover = String.valueOf(manga.getId());
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>();//Arraylist que vai armazenar as linhas do CSV para reescrevê-lo ao final da execução da função.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String IdManga = partes[0];

                if (IdManga.equals(mangaParaRemover)) {
                    partes[9] = "REMOVIDO"; //Muda o status do mangá de DISPONÍVEL para REMOVIDO, assim ambos administrador e cliente perdem acesso ao mangá, sem quebrar o sistema de histórico de compras.
                    String stringManga = String.join(";", partes);
                    linhasRestantes.add(stringManga);
                } else {
                    linhasRestantes.add(linha);
                }
            }
            //Reescrever o arquivo com o mangá removido, mantendo a ordem de IDs original.
            BufferedWriter writer = new BufferedWriter(new FileWriter("./dados/Mangas.csv",StandardCharsets.ISO_8859_1));
            for (String linhaRestante : linhasRestantes) {
                writer.write(linhaRestante);
                writer.newLine();
                writer.flush();  
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void moderarAvaliacao(Avaliacao avaliacao){
        
    }
    
}
