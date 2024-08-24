package Classes;
import java.util.*;

public class CarrinhoDeCompras{
    protected double total;
    protected ArrayList<Manga> produtos;
    
    public CarrinhoDeCompras(){}
    
    public CarrinhoDeCompras(double total, ArrayList<Manga> produtos){
        this.total = total;
        this.produtos = produtos;
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
    public String toString() {
        return "CarrinhoDeCompras{" + "total=" + total + ", produtos=" + produtos + '}';
    }
    
}
