package Classes;
import java.util.*;

public class RelatorioDeVendas {
    protected int id;
    protected String data;
    protected ArrayList<Manga> vendas;
    protected double totalVendas;
    protected Administrador administrador;

    public RelatorioDeVendas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Manga> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Manga> vendas) {
        this.vendas = vendas;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public double calcularTotalVendas(){
        return 0.00; //temporario
    }
}
