package Classes;
import java.util.*;


public abstract class Genero {
    protected String tipo;
    public Genero(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}