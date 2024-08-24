package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Sistema {
    protected static ArrayList<Usuario> usuarios = new ArrayList<>();
    protected static ArrayList<Manga> mangas =  new ArrayList<>();
    
    private static String csvUsuarios = "./dados/Usuarios.csv";// Diretório do arquivo contendo os usuários
    private static String csvMangas = "./dados/Mangas.csv";// Diretório do arquivo contendo os mangás
    
    public static void AdicionarUsuario(Usuario usuario){
        try {
            //Verificar se o arquivo existe
            boolean existe = new File(csvUsuarios).exists();
            
            //Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter(csvUsuarios,StandardCharsets.ISO_8859_1, existe);
            
            if (!existe) {
                writer.write("NomeUsuario;Email;Senha;Cartao;HistoricoCompras;Avaliacoes;CarrinhoCompras\n");
            }
            
            //Escrever os dados do usuario no formato certo
            if (usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                writer.write(cliente.getNomeUsuario() + ";" + cliente.getEmail() + ";" + cliente.getSenha() + ";" + cliente.getCartao() + ";" + cliente.getHistoricoCompras() + ";" + cliente.getAvaliacoes() + ";" + cliente.getCarrinhoCompras() + "\n");
                writer.flush();
                writer.close();
            } else if (usuario instanceof Administrador){
                Administrador administrador = (Administrador) usuario;
                writer.write(administrador.getNomeUsuario() + ";" + administrador.getEmail() + ";" + administrador.getSenha() + "\n");
                writer.flush();
                writer.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Usuario> ListarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
           //Abrir o leitor
           BufferedReader reader = new BufferedReader(new FileReader(csvUsuarios));
           String linha;
           boolean primeiraLinha = true;
            while( (linha = reader.readLine()) != null){
               if (primeiraLinha) {
                   primeiraLinha = false;
                   continue;
               }
               String[] partes = linha.split(";");
               String nomeUsuario = partes[0];
               String email = partes[1];
               String senha = partes[2];
               String cartao = partes[3];
               String HistoricoCompras = partes[4];
               String Avaliacoes = partes[5];
               String CarrinhoCompras = partes[6];
               
               //lista.add()
           }
       } catch (IOException e) {
               e.printStackTrace();
           }
        return lista;
    }
    
    public static void AdicionarManga(Manga manga){
        try {
            //Verificar se o arquivo existe
            boolean existe = new File(csvMangas).exists();
            
            //Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter(csvMangas, StandardCharsets.ISO_8859_1, existe);
            
            if (!existe) {
                writer.write("Id;Titulo;Sinopse;Gênero;Autor;Estoque;Preco;Avaliacoes;Imagem\n");
                
            }
            
            //Escrever os dados do mangá no formato certo
                writer.write("\n");
                writer.flush();
                writer.close();  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Manga> ListarMangas(){
        ArrayList<Manga> lista = new ArrayList<>();
        
        try {
            //Abrir o leitor
            BufferedReader reader = new BufferedReader(new FileReader(csvMangas));
            String linha;
            boolean primeiraLinha = true;
            while( (linha = reader.readLine()) != null){
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";");
                
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String sinopse = partes[2];
                String genero = partes[3];
                String autor = partes[4];
                int estoque = Integer.parseInt(partes[5]);
                double preco = Double.parseDouble(partes[6]);
                String avaliacoes = partes[7];
                String imagem = partes[8];
                
                //lista.add();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Sistema(ArrayList<Usuario> usuarios, ArrayList<Manga> mangas) {
        this.usuarios = usuarios;
        this.mangas = mangas;
    }
    public Sistema(){
    };

    public static void addUsuario(Usuario usuario){
            usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(ArrayList<Manga> mangas) {
        this.mangas = mangas;
    }
    public Usuario Autenticar(String email, String senha){
        return new Usuario(); //temporario
    }

}

 