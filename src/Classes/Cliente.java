package Classes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class Cliente extends Usuario {
    protected ArrayList<Compras> historicoCompras;
    protected ArrayList<Avaliacao> avaliacoes;
    protected CarrinhoDeCompras carrinhoCompras;
    
    public Cliente(){
        super("");
    }
    
    public Cliente(String NomeUsuario, String email, String senha, ArrayList<Compras> Compras, ArrayList<Avaliacao> avaliacoes, CarrinhoDeCompras carrinho){
        super(NomeUsuario);
        Cadastrar(NomeUsuario, email, senha);
        this.historicoCompras = Compras;
        this.avaliacoes = avaliacoes;
        this.carrinhoCompras = carrinho;
    }
    
    
    public void pagar(String senha, double total){
        
    }
    
    public void adicionarAvaliacao(Manga manga, Avaliacao avaliacao){
        Administrador admin = new Administrador();//a avaliação vai tanto pro mangá quanto pro CSV do cliente
        for(Manga m : Sistema.ListarMangas()){
            if(manga.getId() == m.getId()){
                ArrayList<Avaliacao> avaliacoes = m.getAvaliacoes();
                avaliacoes.add(avaliacao);
                m.setAvaliacoes(avaliacoes);
                admin.atualizarManga(m,m);
                break;
            }
        }
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File(pastaUsuarios, this.getNomeUsuario() + ".csv");
        if (!arquivoUsuario.exists()) {
            try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                writer.write("null;null;null;null;null;[]\n");
                writer.flush();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try(FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1, arquivoUsuario.exists())){
                writer.write(manga.getId() + ";" + manga.getTitulo() + ";" + avaliacao.getComentario() + ";" + avaliacao.getNota() + ";" + avaliacao.getData()+"\n");
                writer.flush();
                writer.close();
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }
    
    
    public ArrayList<Compras> getHistoricoCompras() {
        ArrayList<Compras> listaCompras = new ArrayList<>();
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File(pastaUsuarios, this.getNomeUsuario() + ".csv");
        if (!arquivoUsuario.exists()) {
            try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                writer.write("null;null;null;null;null;[]\n");
                writer.flush();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            int count = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader("./dados/usuarios/" + this.getNomeUsuario() +".csv", StandardCharsets.ISO_8859_1))){
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (count == 0){
                        count += 1;
                        continue;
                    } else if (count == 1) {
                        String[] partes = linha.split(";");
                        String historicoCompras = partes[5];
                        System.out.println(historicoCompras);
                        if (!historicoCompras.equals("[]")){
                            historicoCompras = historicoCompras.substring(1, historicoCompras.length() - 1); // Remove os colchetes iniciais e finais
                            String[] parts = historicoCompras.split("(?<=\\}),\\s(?=\\{)"); // Divide em partes, separando por { e }
                            ArrayList<Hashtable<String, String>> hashtables = new ArrayList<>(); // arraylist que vai ter hashtables das compras
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
                                Compras compra = new Compras(Integer.parseInt(hashtable.get("id")), hashtable.get("nomeManga"), Integer.parseInt(hashtable.get("quantidade")), LocalDate.parse(hashtable.get("data")), Double.parseDouble(hashtable.get("preco")));
                                listaCompras.add(compra);
                            }
                        }
                        count += 1;
                    } 
                }
                this.historicoCompras = listaCompras;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return historicoCompras;
    }

    public void setHistoricoCompras(ArrayList<Compras> Compras) {
        this.historicoCompras = Compras;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File(pastaUsuarios, this.getNomeUsuario() + ".csv");
        if (!arquivoUsuario.exists()) {
            try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                writer.write("null;null;null;null;null;[]\n");
                writer.flush();
                return listaAvaliacoes;
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            int count = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader("./dados/usuarios/" + this.getNomeUsuario() +".csv", StandardCharsets.ISO_8859_1))){
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (count == 0||count==1){
                        count += 1;
                        continue;
                    } else if (count>1) {
                        String[] partes = linha.split(";");
                        int idManga = Integer.parseInt(partes[0]);
                        String tituloManga = partes[1];
                        String comentario = partes[2];
                        int nota = Integer.parseInt(partes[3]);
                        LocalDate data = LocalDate.parse(partes[4]);
                        Cliente cliente = new Cliente();
                        cliente.setNomeUsuario(this.getNomeUsuario());
                        Avaliacao avaliacao = new Avaliacao(nota, comentario, data, cliente, idManga);
                        listaAvaliacoes.add(avaliacao);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        this.avaliacoes = listaAvaliacoes;
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public CarrinhoDeCompras getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(CarrinhoDeCompras carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }
    
    
}
