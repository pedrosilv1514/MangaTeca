package Classes;
import java.util.*;

public class Cliente extends Usuario {
    protected ArrayList<Manga> historicoCompras; //mudar
    protected ArrayList<Avaliacao> avaliacoes;
    protected CarrinhoDeCompras carrinhoCompras;
    protected Cartao cartao;
    
    public void Cliente(){
    }
    
    public void pagar(String senha, double total){
        
    }
    public void adicionarAvaliacao(String comentario, int Avaliacao){
    
    }
    
    public ArrayList<Manga> getHistoricoCompras() {
        return historicoCompras;
    }

    public void setHistoricoCompras(ArrayList<Manga> historicoCompras) {
        this.historicoCompras = historicoCompras;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public CarrinhoDeCompras getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(CarrinhoDeCompras carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
}
