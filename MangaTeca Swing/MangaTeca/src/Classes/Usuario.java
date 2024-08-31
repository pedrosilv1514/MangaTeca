package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class Usuario {
    private String NomeUsuario;
    protected String email;
    protected String senha;

    // Construtor que recebe o nome do usuário
    public Usuario(String NomeUsuario){
        this.NomeUsuario = NomeUsuario;
        criarArquivoCSV();
    }

    // Construtor sem argumentos (não utilizado atualmente, mas pode ser necessário)
    public Usuario() {}

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
                Usuario usuario = new Usuario(NomeUsuario);
                usuario.setEmail(email);
                usuario.setSenha(senha);
                Sistema.AdicionarUsuario(usuario);
                salvarDadosUsuario(usuario); // Salva em um arquivo individual

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
        boolean existe = new File("./dados/Usuarios.csv").exists();
        Usuario usuario = null;

        try {
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Não há nenhum usuário cadastrado no sistema, realize seu cadastro antes de acessar o aplicativo!", "Falha ao logar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                BufferedReader reader = new BufferedReader(new FileReader("./dados/Usuarios.csv", StandardCharsets.ISO_8859_1));
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
                        usuario = new Usuario(nomeCSV);  // Instancia o usuário e cria o CSV
                        UsuarioLogado.initialize(usuario); // Inicializa a instância do Singleton
                        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nomeCSV, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        Cadastrado = true;
                        break;
                    } else if (emailCSV.equals(email) && !senhaCSV.equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Sua senha está incorreta, tente novamente.", "Falha ao fazer login", JOptionPane.ERROR_MESSAGE);
                        Cadastrado = true;
                        break;
                    }
                }
                if (!Cadastrado) {
                    JOptionPane.showMessageDialog(null, "Este usuário não está cadastrado no sistema.", "Falha ao fazer login", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    // Método para criar o arquivo CSV específico para o usuário
    private void criarArquivoCSV() {
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
            System.out.println("Pasta criada: " + pastaUsuarios.getAbsolutePath());
        } else {
            System.out.println("Pasta já existe: " + pastaUsuarios.getAbsolutePath());
        }

        File arquivoUsuario = new File(pastaUsuarios, this.NomeUsuario + ".csv");

        try {
            if (!arquivoUsuario.exists()) {
                try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                    writer.write("id_manga;manga;avaliar;avaliacao\n");
                    writer.flush();
                    System.out.println("Arquivo criado: " + arquivoUsuario.getAbsolutePath());
                }
            } else {
                System.out.println("Arquivo já existe: " + arquivoUsuario.getAbsolutePath());
            }
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
