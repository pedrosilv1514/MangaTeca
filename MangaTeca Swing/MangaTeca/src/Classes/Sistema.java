package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
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
                writer.write("NomeUsuario;Email;Senha;HistoricoCompras;Avaliacoes;CarrinhoCompras;Cartao\n");//Escreve o cabeçalho do csv
                writer.write("Administrador;administradoremail.official@gmail.com;Admin123\n");//Insere o administrador no sistema
            }
            
            //Escrever os dados do usuario no formato certo
            if (usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                writer.write(cliente.getNomeUsuario() + ";" + cliente.getEmail() + ";" + cliente.getSenha() + ";" + cliente.getHistoricoCompras() + ";" + cliente.getAvaliacoes() + ";" + cliente.getCarrinhoCompras() + ";" + cliente.getCartao() + "\n");
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
                String historicoCompras = partes[3];
                String avaliacoes = partes[4];
                String carrinhoCompras = partes[5];
                String[] partesCarrinho = carrinhoCompras.split("(?<=\\}),\\s(?=\\{)"); // Divide em partes, separando por { e }
                ArrayList<Hashtable<String, String>> hashtablesCarrinho = new ArrayList<>();
                for (String part : partesCarrinho) {
                    part = part.trim(); // Remove espaços em branco extras
                    part = part.substring(1, part.length() - 1);// Remove colchetes de cada parte
                    Hashtable<String, String> hashtableCarrinho = new Hashtable<>();// Converte a string para um Hashtable
                    String[] keyValuePairs = part.split(",\\s*");//vai separar os valores da string por virgula
                    for (String pair : keyValuePairs) {
                        String[] keyValue = pair.split("=");
                        hashtableCarrinho.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                    System.out.println(hashtableCarrinho);
                    hashtablesCarrinho.add(hashtableCarrinho);// NÃO TÁ DANDO CERTO, TEM QUE REFAZER
                    
                }
                String cartao = partes[6];
                cartao = cartao.substring(1, cartao.length()-1);
                Hashtable<String, String> cartaoHashtable = new Hashtable<>();
                String[] pares = cartao.split(", ");
                for (String par : pares){
                    String[] keyValue = par.split("=");
                    String key = keyValue[0];
                    String value = keyValue[1];
                    cartaoHashtable.put(key,value);
                }
                //System.out.println(cartaoHashtable.get("numero"));
                //System.out.println(cartaoHashtable.get("cvc"));
                //System.out.println(cartaoHashtable.get("validade"));
               
               //lista.add()
           }
       } catch (IOException e) {
               e.printStackTrace();
           }
        return lista;
    }
    
    public static ArrayList<Manga> ListarMangas(){
        //ArrayList<Manga> lista = new ArrayList<>();
        ArrayList<Manga> mangas = new ArrayList<>();
        
        try {
            //Abrir o leitor
            BufferedReader reader = new BufferedReader(new FileReader(csvMangas));
            String linha;
            boolean primeiraLinha = true;
            while( (linha = reader.readLine()) != null){
                if (primeiraLinha) { //se for a primeira linha, será o cabeçalho do arquivo e portanto será pulado
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";"); //linha separada por ;
                ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String sinopse = partes[2];
                String autor = partes[4];
                int estoque = Integer.parseInt(partes[5]);
                double preco = Double.parseDouble(partes[6]);
                String avaliacoes = partes[7];
                String linkImagem = partes[8];
                avaliacoes = avaliacoes.substring(1, avaliacoes.length() - 1); // Remove os colchetes iniciais e finais
                String[] parts = avaliacoes.split("(?<=\\}),\\s(?=\\{)"); // Divide em partes, separando por { e }
                ArrayList<Hashtable<String, String>> hashtables = new ArrayList<>(); //arraylist que vai ter hashtables das avaliações
                for (String part : parts) {
                    part = part.trim(); // Remove espaços em branco extras
                    part = part.substring(1, part.length() - 1);// Remove colchetes de cada parte
                    Hashtable<String, String> hashtable = new Hashtable<>();// Converte a string para um Hashtable
                    String[] keyValuePairs = part.split(",\\s*");//vai separar os valores da string por virgula
                    for (String pair : keyValuePairs) {
                        String[] keyValue = pair.split("=");
                        hashtable.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                    hashtables.add(hashtable);
                    
                }
                for (Hashtable<String, String> hashtable : hashtables) {
                    Avaliacao avaliacao = new Avaliacao(Integer.parseInt(hashtable.get("nota")),hashtable.get("comentario"),LocalDate.parse(hashtable.get("data")));
                    listaAvaliacoes.add(avaliacao);
                   /* System.out.println("Avaliação:\nNota: " + hashtable.get("nota"));
                    System.out.println("Comentário: " + hashtable.get("comentario"));
                    System.out.println("Data: " + hashtable.get("data"));
                    System.out.println("Cliente: " + hashtable.get("cliente"));
                    System.out.println("Mangá: " + hashtable.get("manga"));*/
                }
                if(partes[3].equals("Romance")){
                    Romance romance = new Romance(partes[3]);
                    Manga manga = new Manga(id,titulo,sinopse,romance,autor,estoque,preco,listaAvaliacoes,linkImagem);  
                    System.out.println(manga);
                    mangas.add(manga);
                } else if (partes[3].equals("Comedia")){
                    Comedia comedia = new Comedia(partes[3]);
                    Manga manga = new Manga(id,titulo,sinopse,comedia,autor,estoque,preco,listaAvaliacoes,linkImagem);
                    System.out.println(manga);
                    mangas.add(manga);
                } else if (partes[3].equals("Acao")){
                    Acao acao = new Acao(partes[3]);
                    Manga manga = new Manga(id,titulo,sinopse,acao,autor,estoque,preco,listaAvaliacoes,linkImagem);
                    System.out.println(manga);
                    mangas.add(manga);
                }
                
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mangas;
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

 