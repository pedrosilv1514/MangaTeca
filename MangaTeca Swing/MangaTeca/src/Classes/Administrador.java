package Classes;
import java.util.*;


public class Administrador extends Usuario {
    protected RelatorioDeVendas relatorioDeVendas;
    
    public Administrador(){
    }
    
    public void adicionarManga(Manga manga){
    
    }
    public void atualizarManga(Manga manga){
        
    }
    public void removerManga(Manga manga){
        
    }
    public void atualizarEstoque(Manga manga, int novaQuantidade){
        
    }
    public void moderarAvaliacao(Avaliacao avaliacao){
        
    }
    public RelatorioDeVendas gerarRelatorioDeVendas(){
        return relatorioDeVendas; //temporario
    }

    public RelatorioDeVendas getRelatorioDeVendas() {
        return relatorioDeVendas;
    }

    public void setRelatorioDeVendas(RelatorioDeVendas relatorioDeVendas) {
        this.relatorioDeVendas = relatorioDeVendas;
    }
    
}
