package Classes;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.swing.JOptionPane;

public class Usuario {
    protected String NomeUsuario;
    protected String email;
    protected String senha;
    
    public static void Cadastrar(String NomeUsuario, String email, String senha){
        boolean UsuarioJaCadastrado = false;
        boolean existe = new File("./dados/Usuarios.csv").exists();
            
        try { 
           FileWriter writer = new FileWriter("./dados/Usuarios.csv",StandardCharsets.ISO_8859_1, existe);
            
            if (!existe) {
                writer.write("NomeUsuario;Email;Senha;HistoricoCompras;Avaliacoes;CarrinhoCompras;Cartao\n");//Escreve o cabeçalho do csv
                writer.flush();
                writer.close();
            }
            BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv"));
            String linha;
            boolean primeiraLinha = true;
            while( (linha = reader.readLine()) != null){
                if (primeiraLinha) {
                   primeiraLinha = false;
                   continue;
                }
                String[] partes = linha.split(";");
                String nomeUsuarioCSV = partes[0];
                String emailCSV = partes[1];
                if(nomeUsuarioCSV.equals(NomeUsuario) || emailCSV.equals(email)){
                    UsuarioJaCadastrado = true;
                    break;
                }
               
            }
            if(UsuarioJaCadastrado == false){
                Cliente cliente = new Cliente();
                cliente.setNomeUsuario(NomeUsuario);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                Sistema.AdicionarUsuario(cliente);
                JOptionPane.showMessageDialog(null, "Novo usuário cadastrado:" + NomeUsuario,"Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(null, "Usuário ou E-mail já está cadastrado no sistema." ,"Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
            } 
            } catch (IOException e){
                e.printStackTrace();
            }
    }
    public boolean Logar(String email, String senha){
        return true; //temporario
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return NomeUsuario;
    }
    
}
