package Classes;

/*
Teste de criação de padrão de projeto para que o usuariopermaneça logado

*/
public class UsuarioLogado {
    private static UsuarioLogado instance;
    private Usuario usuario;

    // Construtor privado para evitar instanciação externa
    private UsuarioLogado() {}

    // Método estático para obter a instância única
    public static UsuarioLogado getInstance() {
        if (instance == null) {
            instance = new UsuarioLogado();
        }
        return instance;
    }

    // Getter e Setter para o usuário logado
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
