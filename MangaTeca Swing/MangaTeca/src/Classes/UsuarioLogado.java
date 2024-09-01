package Classes;

/*
Classe para resolver a questão do usuário permanecer logado
Famoso padrão de projeto (que dor)
*/
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UsuarioLogado {
    private static UsuarioLogado instancia;
    private Usuario usuario;

    // Construtor privado para garantir o padrão Singleton
    private UsuarioLogado(Usuario usuario) {
        this.usuario = usuario;
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

    // Método para criar o arquivo CSV do usuário
    private void criarArquivoUsuario() {
        if (usuario == null || usuario.getNomeUsuario() == null || usuario.getNomeUsuario().trim().isEmpty()) {
            System.out.println("Nome de usuário inválido.");
            return;
        }
        String nomeArquivo = "./dados/usuarios/" + usuario.getNomeUsuario() + ".csv";
        try (FileWriter writer = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1)) {
            writer.write("id_manga;manga;avaliar;avaliacao\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para redefinir o Singleton (útil para testes ou logout)
    public static void reset() {
        instancia = null;
    }
}