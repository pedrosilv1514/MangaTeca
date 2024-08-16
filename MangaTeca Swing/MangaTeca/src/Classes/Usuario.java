package Classes;
import java.util.*;

public class Usuario {
    protected String NomeUsuario;
    protected String email;
    protected String senha;

    public void Cadastrar(String NomeUsuario, String senha, String email){
        this.NomeUsuario = NomeUsuario;
        this.senha = senha;
        this.email = email;
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
    
}
