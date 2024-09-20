package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

//Classe que representa o carrinho de compras do cliente, que armazena informações dos mangás a serem comprados.

public class CarrinhoDeCompras {
    private double total;
    private ArrayList<Compras> produtos; //ArrayList de Compras, uma classe feita para representar os mangás no carrinho e acessá-los sem dificuldade.

    public CarrinhoDeCompras() {
        this.total = 0.0;
        this.produtos = new ArrayList<>();
    }

    public CarrinhoDeCompras(double total, ArrayList<Compras> produtos) {
        this.total = total;
        this.produtos = produtos;
    }

    public void zerarCarrinho() {
        produtos.clear();
        total = 0.0;
    }

    public void adicionarManga(Manga manga) {
        boolean itemEncontrado = false;
        for (Compras compra : produtos) {
            if (compra.getId() == manga.getId()) {
                compra.setQuantidade(compra.getQuantidade() + 1); // Se o mangá já estiver no carrinho, sua quantidade será aumentada em 1.
                itemEncontrado = true;
                break;
            }
        }
        if (!itemEncontrado) {
            produtos.add(new Compras(manga.getId(), manga.getTitulo(), 1, LocalDate.now(), manga.getPreco()));//Se o produto não for encontrado no carrinho, será adicionado manualmente com a instanciação de um novo mangá.
        }
        total += manga.getPreco();
    }

    public void finalizarCompra(String nomeUsuario, ArrayList<Compras> compras) {
        // Função para finalizar a compra, adicionando os mangás ao histórico de compras do cliente e deduzindo do estoque a quantia de mangás comprados.
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File(pastaUsuarios, nomeUsuario + ".csv");
        if (!arquivoUsuario.exists()) {
            try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                writer.write("null;null;null;null;null;" + compras + "\n");
                writer.flush();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            int count = 0;
            ArrayList<String> linhasRestantes = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("./dados/usuarios/" + nomeUsuario +".csv", StandardCharsets.ISO_8859_1))){
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (count == 0){
                        linhasRestantes.add(linha);
                        count += 1;
                        continue;
                    } else if (count == 1){
                        String[] partes = linha.split(";");
                        ArrayList<Compras> listaCompras = new ArrayList<>();
                        String historicoCompras = partes[5];
                        if (!historicoCompras.equals("[]")){
                            historicoCompras = historicoCompras.substring(1, historicoCompras.length() - 1); // Remove os colchetes iniciais e finais
                            String[] parts = historicoCompras.split("(?<=\\}),\\s(?=\\{)"); // Divide em partes, separando por { e }
                            ArrayList<Hashtable<String, String>> hashtables = new ArrayList<>(); // Arraylist que vai ter hashtables das compras
                            for (String part : parts) {
                                part = part.trim(); // Remove espaços em branco extras
                                part = part.substring(1, part.length() - 1); // Remove colchetes de cada parte
                                Hashtable<String, String> hashtable = new Hashtable<>(); // Converte a string para um Hashtable
                                String[] keyValuePairs = part.split(",\\s*"); // Vai separar os valores da string por vírgula
                                for (String pair : keyValuePairs) {
                                    String[] keyValue = pair.split("="); //Separa key e valor por "="
                                    hashtable.put(keyValue[0].trim(), keyValue[1].trim()); //Coloca os valores na hashtable
                            }
                            hashtables.add(hashtable);
                        }
                            for (Hashtable<String, String> hashtable : hashtables) {
                                Compras compras2 = new Compras(Integer.parseInt(hashtable.get("id")), hashtable.get("nomeManga"), Integer.parseInt(hashtable.get("quantidade")), LocalDate.parse(hashtable.get("data")), Double.parseDouble(hashtable.get("preco")));
                                listaCompras.add(compras2);
                            }
                            for(Compras c : compras){
                                listaCompras.add(c);
                            }
                            linhasRestantes.add("null;null;null;null;null;"+listaCompras);
                            count += 1;
                        } else {
                            for(Compras c : compras){
                                listaCompras.add(c);
                            }
                            linhasRestantes.add("null;null;null;null;null;"+listaCompras);
                            count += 1;
                        }   
                    } else {
                        linhasRestantes.add(linha);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter("./dados/usuarios/" + nomeUsuario +".csv",StandardCharsets.ISO_8859_1));
                for (String linhaRestante : linhasRestantes) {
                    writer.write(linhaRestante);
                    writer.newLine();
                    writer.flush();
                }
            writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        // Zera o carrinho após a compra
        zerarCarrinho();
    }

    public double getTotal() {
        double subtotal = 0.0;
        for (Compras compra : this.getProdutos()) {
            subtotal += compra.getPreco() * compra.getQuantidade();
        }
        total = subtotal;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Compras> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Compras> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return produtos.toString();
    }
}
