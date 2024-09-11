package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class Sistema {
    protected static ArrayList<Usuario> usuarios = new ArrayList<>();
    protected static ArrayList<Manga> mangas = new ArrayList<>();
    
    private static String csvUsuarios = "./dados/Usuarios.csv"; // Diretório do arquivo contendo os usuários
    private static String csvMangas = "./dados/Mangas.csv"; // Diretório do arquivo contendo os mangás
    
    // Método para listar os usuários do sistema
    public static ArrayList<Hashtable<String, String>> ListarUsuarios() {
        ArrayList<Hashtable<String, String>> lista = new ArrayList<>();
        try {
            // Abrir o leitor
            BufferedReader reader = new BufferedReader(new FileReader(csvUsuarios));
            String linha;
            boolean primeiraLinha = true;
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";");
                String nomeUsuario = partes[0];
                String emailUsuario = partes[1];
                Hashtable<String, String> usuario = new Hashtable<>();
                usuario.put("nome", nomeUsuario);
                usuario.put("email", emailUsuario);
                lista.add(usuario);         
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static Manga procuraManga(int id){
        Manga manga = new Manga();
        for(Manga m : Sistema.ListarMangas()){
            if(m.getId() == id){
                manga = m;
                return manga;
            }
        }
        return manga;
    }
    
    public static List<Manga> getTop3(){
        List<Manga> top3 = new ArrayList<>();
        ArrayList<Manga> mangasDisponiveis = new ArrayList<>();
        for(Manga manga : Sistema.ListarMangas()){
            if((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){
                mangasDisponiveis.add(manga);
            }
        }
        for (int i = 0; i < mangasDisponiveis.size() - 1; i++) {
            for (int j = 0; j < mangasDisponiveis.size() - 1 - i; j++) {
                if (mangasDisponiveis.get(j).calcularMedia(mangasDisponiveis.get(j).getAvaliacoes()) < mangasDisponiveis.get(j + 1).calcularMedia(mangasDisponiveis.get(j+1).getAvaliacoes())) {
                    Manga temp = mangasDisponiveis.get(j);
                    mangasDisponiveis.set(j, mangasDisponiveis.get(j + 1));
                    mangasDisponiveis.set(j + 1, temp);
                }
            }
        }
        top3 = mangasDisponiveis.subList(0, Math.min(3, mangasDisponiveis.size()));
        return top3;
    }
    
    // Método para listar os mangás do sistema
    public static ArrayList<Manga> ListarMangas() {
        ArrayList<Manga> mangas = new ArrayList<>();
        boolean existe = new File(csvMangas).exists();
        if (!existe){
            return mangas;
        }
        try {
            // Abrir o leitor
            BufferedReader reader = new BufferedReader(new FileReader(csvMangas));
            String linha;
            boolean primeiraLinha = true;
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) { // se for a primeira linha, será o cabeçalho do arquivo e, portanto, será pulado
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";"); // linha separada por ;
                ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String sinopse = partes[2];
                String autor = partes[4];
                int estoque = Integer.parseInt(partes[5]);
                double preco = Double.parseDouble(partes[6]);
                String avaliacoes = partes[7];
                String linkImagem = partes[8];
                String status = partes[9];
                if (!avaliacoes.equals("[]")){
                    avaliacoes = avaliacoes.substring(1, avaliacoes.length() - 1); // Remove os colchetes iniciais e finais
                    String[] parts = avaliacoes.split("(?<=\\}),\\s(?=\\{)"); // Divide em partes, separando por { e }
                    ArrayList<Hashtable<String, String>> hashtables = new ArrayList<>(); // arraylist que vai ter hashtables das avaliações
                for (String part : parts) {
                    part = part.trim(); // Remove espaços em branco extras
                    part = part.substring(1, part.length() - 1); // Remove colchetes de cada parte
                    Hashtable<String, String> hashtable = new Hashtable<>(); // Converte a string para um Hashtable
                    String[] keyValuePairs = part.split(",\\s*"); // vai separar os valores da string por vírgula
                    for (String pair : keyValuePairs) {
                        String[] keyValue = pair.split("=");
                        hashtable.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                    hashtables.add(hashtable);
                }
                for (Hashtable<String, String> hashtable : hashtables) {
                    Cliente cliente = new Cliente();
                    cliente.setNomeUsuario(hashtable.get("cliente"));
                    Avaliacao avaliacao = new Avaliacao(Integer.parseInt(hashtable.get("nota")), hashtable.get("comentario"), LocalDate.parse(hashtable.get("data")), cliente, id);
                    listaAvaliacoes.add(avaliacao);
                }
                }

                if (partes[3].equals("Romance")) {
                    Romance romance = new Romance(partes[3]);
                    Manga manga = new Manga(id, titulo, sinopse, romance, autor, estoque, preco, listaAvaliacoes, linkImagem);
                    if (partes[9].equals("REMOVIDO")){
                        manga.setStatus("REMOVIDO");
                    }
                    mangas.add(manga);
                } else if (partes[3].equals("Comedia")) {
                    Comedia comedia = new Comedia(partes[3]);
                    Manga manga = new Manga(id, titulo, sinopse, comedia, autor, estoque, preco, listaAvaliacoes, linkImagem);
                    if (partes[9].equals("REMOVIDO")){
                        manga.setStatus("REMOVIDO");
                    }
                    mangas.add(manga);
                } else if (partes[3].equals("Acao")) {
                    Acao acao = new Acao(partes[3]);
                    Manga manga = new Manga(id, titulo, sinopse, acao, autor, estoque, preco, listaAvaliacoes, linkImagem);
                    if (partes[9].equals("REMOVIDO")){
                        manga.setStatus("REMOVIDO");
                    }
                    mangas.add(manga);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mangas;
    }
    
    public static void alterarCadastro(String nomeAntigo, String emailAntigo, String nomeNovo, String emailNovo, String senhaNova){
        String linha;
        ArrayList<String> linhasRestantes = new ArrayList<>();
        File arquivoUsuarios = new File("./dados/Usuarios.csv");
        File csvAntigo = new File("./dados/usuarios/" + nomeAntigo + ".csv");
        File csvNovo = new File("./dados/usuarios/" + nomeNovo + ".csv");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv",StandardCharsets.ISO_8859_1));
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String nome = partes[0];
                String email = partes[1];
                String senha = partes[2];
                if(nome.equals(nomeAntigo)||emailAntigo.equals(email)){
                    String atualizado = nomeNovo + ";" + emailNovo + ";" + senhaNova;
                    linhasRestantes.add(atualizado);
                } else {
                    linhasRestantes.add(linha);
                }   
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./dados/Usuarios.csv",StandardCharsets.ISO_8859_1));
            for (String linhaRestante : linhasRestantes) {
                writer.write(linhaRestante);
                writer.newLine();
                writer.flush();
            }
            if(!nomeAntigo.equals(nomeNovo)){
                csvAntigo.renameTo(csvNovo);
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // Construtor da classe Sistema
    public Sistema(ArrayList<Usuario> usuarios, ArrayList<Manga> mangas) {
        Sistema.usuarios = usuarios;
        Sistema.mangas = mangas;
    }

    // Construtor padrão
    public Sistema() {}

    // Adicionar um usuário ao ArrayList de usuários
    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Obter a lista de usuários
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Definir a lista de usuários
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }

    // Obter a lista de mangás
    public List<Manga> getMangas() {
        return mangas;
    }

    // Definir a lista de mangás
    public void setMangas(ArrayList<Manga> mangas) {
        Sistema.mangas = mangas;
    }

    // Autenticar um usuário (ainda precisa ser implementado)
    public Usuario Autenticar(String email, String senha) {
        return new Usuario(""); // temporário, até que seja implementado
    }
}
