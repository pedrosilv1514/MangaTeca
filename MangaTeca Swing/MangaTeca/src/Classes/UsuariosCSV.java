package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UsuariosCSV {
    // Caminho do arquivo a ser acessado
    private static String nomeArquivo = "./dados/Usuarios.csv";
    
    public static void AdicionarUsuario(Usuario usuario){
        try {
            //Verificar se o arquivo existe
            boolean existe = new File(nomeArquivo).exists();
            
            //Abre o escritor para adicionar dados ao arquivo
            FileWriter writer = new FileWriter(nomeArquivo,StandardCharsets.ISO_8859_1, existe);
            
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
}
