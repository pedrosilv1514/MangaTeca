package Classes;
import java.time.LocalDate;
import java.util.*;

public class Compras {
    protected int id;
    protected int quantidade;
    protected LocalDate data;
    
    public Compras(int id, int quantidade, LocalDate data){
    this.id = id;
    this.quantidade = quantidade;
    this.data = data;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", quantidade=" + quantidade + ", data=" + data + '}';
    }
    
}
