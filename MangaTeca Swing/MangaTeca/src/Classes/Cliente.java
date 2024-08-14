package Classes;
import java.util.*;

public class Cliente extends Usuario {
    protected double LimiteConta;
    protected ArrayList<Object> historicoCompras;
    protected ArrayList<Avaliacao> avaliacoes;
    protected ArrayList<CarrinhoDeCompras> carrinhoCompras;
    
    public void Cliente(){
    }
    public void registrar(){
        
    }
    public void pagar(String senha, double total){
        
    }
    public void adicionarAvaliacao(String comentario, int Avaliacao){
    }
    public void comprar(){
        
    }
    public double getLimiteConta() {
        return LimiteConta;
    }

    public void setLimiteConta(double LimiteConta) {
        this.LimiteConta = LimiteConta;
    }

    public ArrayList<Object> getHistoricoCompras() {
        return historicoCompras;
    }

    public void setHistoricoCompras(ArrayList<Object> historicoCompras) {
        this.historicoCompras = historicoCompras;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<CarrinhoDeCompras> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(ArrayList<CarrinhoDeCompras> carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }
    
}
