package Classes;
import java.util.*;

public class Usuario {
    protected String NomeUsuario;
    protected int id;
    protected String email;
    protected String senha;
    public Usuario(){
        
    }
    public void Cadastrar(String NomeUsuario, String senha, String email){
        this.NomeUsuario = NomeUsuario;
        this.senha = senha;
        this.email = email;
    }
    public boolean Logar(String email, String senha){
        return true; //temporario
    }
    public void Avaliar(Manga manga, float nota, String comentario){
        
    }
    public void AdicionarAoCarrinho(Manga manga){
        
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
