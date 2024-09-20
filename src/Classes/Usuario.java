package Classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

//Superclasse que representa os usuários que utilizam o aplicativo.

public class Usuario {
    private String NomeUsuario;
    private String email;
    private String senha;
    private CarrinhoDeCompras carrinhoDeCompras;

    // Construtor que recebe o nome do usuário
    public Usuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
        this.carrinhoDeCompras = new CarrinhoDeCompras(); // Inicializa o carrinho
        criarArquivoCSV();
    }

    // Construtor sem argumentos, apenas para utilizar métodos específicos do cliente ou administrador
    public Usuario() {}
    
    // Método para cadastrar um novo usuário
    public static void Cadastrar(String NomeUsuario, String email, String senha) {
        File arquivoUsuarios = new File("./dados/Usuarios.csv");
        boolean usuarioJaCadastrado = false;
        boolean existe = arquivoUsuarios.exists();

        // Verifica se o usuário já está cadastrado
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoUsuarios, StandardCharsets.ISO_8859_1))) {
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
                    usuarioJaCadastrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!usuarioJaCadastrado) {
            // Adiciona o novo usuário ao arquivo CSV
            try (FileWriter writer = new FileWriter(arquivoUsuarios, StandardCharsets.ISO_8859_1, existe)) {
                if (!existe) {
                    writer.write("NomeUsuario;Email;Senha\n");
                    writer.write("Administrador;administrador@mangateca.com;administrador\n");
                    //O administrador é adicionado automaticamente caso o arquivo de usuarios não existia.
                }
                writer.write(NomeUsuario + ";" + email + ";" + senha + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Cria o arquivo CSV do usuário individual apenas se necessário
            Usuario usuario = new Usuario(NomeUsuario);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            salvarDadosUsuario(usuario);

            JOptionPane.showMessageDialog(null, "Novo usuário cadastrado: " + NomeUsuario, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou E-mail já está cadastrado no sistema.", "Falha ao cadastrar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static Usuario Logar(String email, String senha) {
        // Método para logar um usuário
        boolean Cadastrado = false;
        boolean existe = new File("./dados/usuarios.csv").exists();
        Usuario usuario = null;

        try {
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Não há nenhum usuário cadastrado no sistema, realize seu cadastro antes de acessar o aplicativo!", "Falha ao logar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                BufferedReader reader = new BufferedReader(new FileReader("./dados/usuarios.csv", StandardCharsets.ISO_8859_1));
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
                        usuario.setSenha(senha);
                        usuario.setNomeUsuario(nomeCSV);
                        usuario.setEmail(email);
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

    public static void salvarDadosUsuario(Usuario usuario) {
        // Método para salvar os dados do usuário em um arquivo CSV individual
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs();
        }

        File arquivoUsuario = new File(pastaUsuarios, usuario.getNomeUsuario() + ".csv");
        boolean existe = arquivoUsuario.exists();
        if(!existe){
            try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
            writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
            writer.write("null;null;null;null;null;[]\n");
            writer.flush();
            writer.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }

    private void criarArquivoCSV() {
        // Método para criar o arquivo CSV específico para o usuário
        File pastaUsuarios = new File("./dados/usuarios/");
        if (!pastaUsuarios.exists()) {
            pastaUsuarios.mkdirs(); // Cria a pasta se ela não existir
        }

        File arquivoUsuario = new File(pastaUsuarios, this.NomeUsuario + ".csv");

        try {
            if (!arquivoUsuario.exists()) {
                try (FileWriter writer = new FileWriter(arquivoUsuario, StandardCharsets.ISO_8859_1)) {
                    writer.write("id_manga;manga;avaliacao;nota;data;historico_compras\n");
                    writer.write("null;null;null;null;null;[]\n");
                    writer.flush();
                    writer.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
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
