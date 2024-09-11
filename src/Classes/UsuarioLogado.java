package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UsuarioLogado {
    private static UsuarioLogado instancia;
    private Usuario usuario;
    private CarrinhoDeCompras carrinho;
    private int idSelecionado;

    // Construtor privado para garantir o padrão Singleton
    private UsuarioLogado(Usuario usuario) {
        this.usuario = usuario;
        this.carrinho = new CarrinhoDeCompras(); // Inicialize o carrinho
        criarArquivoUsuario();
    }

    // Método para retornar a instância única da classe
    public static UsuarioLogado getInstance() {
        if (instancia == null) {
            throw new IllegalStateException("Instância não foi inicializada. Use o método 'initialize' primeiro.");
        }
        return instancia;
    }

    // Método para inicializar a instância
    public static void initialize(Usuario usuario) {
        if (instancia == null) {
            instancia = new UsuarioLogado(usuario);
        }
    }

    // Método para obter o usuário logado
    public Usuario getUsuario() {
        return usuario;
    }

    // Método para obter o carrinho do usuário logado
    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    // Método para criar o arquivo CSV do usuário
    private void criarArquivoUsuario() {
        if (usuario == null || usuario.getNomeUsuario() == null || usuario.getNomeUsuario().trim().isEmpty()) {
            System.out.println("Nome de usuário inválido.");
            return;
        }
        String nomeArquivo = "./dados/usuarios/" + usuario.getNomeUsuario() + ".csv";
        boolean existe = new File(nomeArquivo).exists();
        if(!existe){
            try (FileWriter writer = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1)) {
                writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                writer.write("null;null;null;null;null;[]\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public int getIdSelecionado() {
        return idSelecionado;
    }

    public void setIdSelecionado(int idSelecionado) {
        this.idSelecionado = idSelecionado;
    }
    // Método para a realização do logout
    public void logout() {
        instancia = null; // Reseta a instância, permitindo que outro usuário possa logar
    }
}
