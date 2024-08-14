package Classes;

import java.util.*;

public class Sistema {
    protected List<Usuario> usuarios;
    protected List<Manga> mangas;

    public Sistema(List<Usuario> usuarios, List<Manga> mangas) {
        this.usuarios = usuarios;
        this.mangas = mangas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
    public Usuario Autenticar(String email, String senha){
        return new Usuario(); //temporario
    }
    public void comprarManga(Usuario usuario, Manga manga){
        
    }
    
}
