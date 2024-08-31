package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class Usuario {
    private String NomeUsuario;
    protected String email;
    protected String senha;

    // Método para cadastrar um novo usuário
    public static void Cadastrar(String NomeUsuario, String email, String senha) {
        boolean UsuarioJaCadastrado = false;
        boolean existe = new File("./dados/Usuarios.csv").exists();

        try (FileWriter writer = new FileWriter("./dados/Usuarios.csv", StandardCharsets.ISO_8859_1, existe)) {

            if (!existe) {
                writer.write("NomeUsuario;Email;Senha\n");
                writer.write("Administrador;administradoremail.official@gmail.com;Admin123\n");
                writer.flush();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv", StandardCharsets.ISO_8859_1))) {
                String linha;
                boolean primeiraLinha = true;
                while ((linha = reader.readLine()) != null) {
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue;
                    }
                    String[] partes = linha.split(";");
                    String nomeUsuarioCSV = partes[0];
                    String emailCSV = partes[1];
                    if (nomeUsuarioCSV.equals(NomeUsuario) || emailCSV.equals(email)) {
                        UsuarioJaCadastrado = true;
                        break;
                    }
                }
            }
            if (!UsuarioJaCadastrado) {
                Cliente cliente = new Cliente();
                cliente.setNomeUsuario(NomeUsuario);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                Sistema.AdicionarUsuario(cliente);
                salvarDadosUsuario(cliente); // Salva em um arquivo individual

                // Mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Novo usuário cadastrado: " + NomeUsuario, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou E-mail já está cadastrado no sistema.", "Falha ao cadastrar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para logar um usuário
    public static Usuario Logar(String email, String senha) {
        boolean Cadastrado = false;
        Usuario usuario = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv", StandardCharsets.ISO_8859_1))) {
            String linha;
            boolean primeiraLinha = true;
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] partes = linha.split(";");
                String nomeCSV = partes[0];
                String emailCSV = partes[1];
                String senhaCSV = partes[2];
                if (emailCSV.equals(email) && senhaCSV.equals(senha)) {
                    usuario = new Usuario();
                    usuario.setNomeUsuario(nomeCSV);
                    usuario.setEmail(emailCSV);
                    usuario.setSenha(senhaCSV);
                    UsuarioLogado.getInstance().setUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "Bem vindo(a), " + nomeCSV, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    Cadastrado = true;
                    break;
                }
            }
            if (!Cadastrado) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado ou senha incorreta.", "Falha ao fazer login", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para carregar dados específicos de um usuário a partir de um arquivo CSV
    private static Usuario carregarDadosUsuario(String nomeUsuario) {
        Usuario usuario = new Usuario();
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File("./dados/usuarios/" + nomeUsuario + ".csv");

        if (arquivoUsuario.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoUsuario, StandardCharsets.ISO_8859_1))) {
                String linha = reader.readLine(); // Supondo que a primeira linha contém os dados
                if (linha != null) {
                    String[] partes = linha.split(";");
                    usuario.setNomeUsuario(partes[0]);
                    usuario.setEmail(partes[1]);
                    usuario.setSenha(partes[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Arquivo do usuário não encontrado: " + arquivoUsuario.getAbsolutePath());
        }
        return usuario;
    }

    // Método para salvar os dados do usuário em um arquivo CSV individual
    public static void salvarDadosUsuario(Usuario usuario) {
        File pastaUsuarios = new File("./dados/usuarios/");
    if (!pastaUsuarios.exists()) {
        pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
    }

        File arquivoUsuario = new File("./dados/usuarios/" + usuario.getNomeUsuario() + ".csv");

        try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
            writer.write(usuario.getNomeUsuario() + ";" + usuario.getEmail() + ";" + usuario.getSenha() + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
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
