package Classes;
import java.time.LocalDate;
import java.util.*;

public class Avaliacao {
    protected int nota;
    protected String comentario;
    protected LocalDate data;
    protected Cliente cliente;
    protected String manga;
    
    public Avaliacao(){}
    
    public Avaliacao(int nota, String comentario, LocalDate data){
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }
    public void Avaliar(int nota, String comentario){
        
    }
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public String getManga() {
        return manga;
    }

    public void setManga(String manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "{" + "nota=" + nota + ", comentario=" + comentario + ", data=" + data + ", cliente=" + cliente + ", manga=" + manga + '}';
    }
    
    
      
}
