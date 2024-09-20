package Classes;
import java.time.LocalDate;

//Classe que representa as avaliações que os clientes dão aos mangás.

public class Avaliacao {
    protected int nota;
    protected String comentario;
    protected LocalDate data;
    protected Cliente cliente;
    protected int idManga;
    
    public Avaliacao(){} //Construtor vazio para caso seja necessário utilizar apenas os métodos da classe.
    
    public Avaliacao(int nota, String comentario, LocalDate data, Cliente cliente, int idManga){
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
        this.cliente = cliente;
        this.idManga = idManga;
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

    public int getIdManga() {
        return idManga;
    }

    public void setIdManga(int idManga) {
        this.idManga = idManga;
    }

    @Override
    public String toString() {
        return "{" + "nota=" + nota + ", comentario=" + comentario + ", data=" + data + ", cliente=" + cliente + ", manga=" + idManga + '}';
    }
    
    
      
}
