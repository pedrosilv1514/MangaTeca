package Classes;
import Classes.Cliente;
import Classes.Sistema;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                writer.write("Administrador;administradoremail.official@gmail.com;Admin123\n");//Insere o administrador no sistema
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
                String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
                Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
                Matcher matcher = emailPat.matcher(email);
                if(matcher.find() == false){
                    JOptionPane.showMessageDialog(null, "O E-mail inserido é inválido." ,"Falha ao cadastrar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                Cliente cliente = new Cliente();
                cliente.setNomeUsuario(NomeUsuario);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                Sistema.AdicionarUsuario(cliente);
                JOptionPane.showMessageDialog(null, "Novo usuário cadastrado:" + NomeUsuario,"Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou E-mail já está cadastrado no sistema." ,"Falha ao cadastrar", JOptionPane.INFORMATION_MESSAGE);
            } 
            } catch (IOException e){
                e.printStackTrace();
            }
    }
    public static void Logar(String email, String senha){
        boolean Cadastrado = false;
        boolean existe = new File("./dados/Usuarios.csv").exists();
            
        try {
           FileWriter writer = new FileWriter("./dados/Usuarios.csv",StandardCharsets.ISO_8859_1, existe);
           if (!existe) {
               JOptionPane.showMessageDialog(null, "Não há nenhum usuário cadastrado no sistema, realize seu cadastro antes de acessar o aplicativo!","Falha ao logar", JOptionPane.INFORMATION_MESSAGE);
           } else {
           BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv"));
           String linha;
           boolean primeiraLinha = true;
            while( (linha = reader.readLine()) != null){
               if (primeiraLinha) {
                   primeiraLinha = false;
                   continue;
                }
               String[] partes = linha.split(";");
               String nomeCSV = partes[0];
               String emailCSV = partes[1];
               String senhaCSV = partes[2];
               if(emailCSV.equals(email) && senhaCSV.equals(senha)){
                   JOptionPane.showMessageDialog(null, "Bem vindo(a), " + nomeCSV,"Sucesso", JOptionPane.INFORMATION_MESSAGE);
                   Cadastrado = true;
                   break;
               } else if (emailCSV.equals(email) && !senhaCSV.equals(senha)){
                   JOptionPane.showMessageDialog(null, "Sua senha está incorreta, tente novamente.","Falha ao fazer login", JOptionPane.ERROR_MESSAGE);
                   Cadastrado = true;
                   break;
               } 
            }
            if(Cadastrado==false){
                   JOptionPane.showMessageDialog(null,"Este usuário não está cadastrado no sistema.","Falha ao fazer login", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
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
