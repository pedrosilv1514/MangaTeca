package Classes;
import java.util.*;

public class CarrinhoDeCompras implements Pagavel {
    protected double total;
    protected ArrayList<Manga> produtos;
    
    public void CarrinhoDeCompras(){
    
    }
    public void ZerarCarrinho(){
        
    }
    public void AdicionarManga(Manga manga){
        
    }
    public void RemoverManga(Manga manga){
        
    }
    public void FinalizarCompra(){
        
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Manga> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Manga> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void realizarPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcularValor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
