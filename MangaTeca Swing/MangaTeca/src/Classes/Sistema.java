package Classes;

import java.util.*;

public class Sistema {
    protected static ArrayList<Usuario> usuarios = new ArrayList<>();
    protected static ArrayList<Manga> mangas =  new ArrayList<>();
    
    public Sistema(ArrayList<Usuario> usuarios, ArrayList<Manga> mangas) {
        this.usuarios = usuarios;
        this.mangas = mangas;
    }
    public Sistema(){
    };

    public static void addUsuario(Usuario usuario){
            usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(ArrayList<Manga> mangas) {
        this.mangas = mangas;
    }
    public Usuario Autenticar(String email, String senha){
        return new Usuario(); //temporario
    }

}

 