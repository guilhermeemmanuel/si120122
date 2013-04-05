/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Guilherme
 */
public class Sistema {
    
    private static Sistema sistemaInstance;
    private Collection<Texto> textosCadastrados;
    private Estrategia estrategia;
    
    private Sistema() {
        textosCadastrados = new LinkedList<Texto>();
        estrategia = new EstrategiaAleatoriaSemRepeticao();
    }
    
    public void cadastraTexto(String texto){
        if(texto != null){
            textosCadastrados.add(new Texto(texto));
        }
            
    }
        
    
    private void cadastraTexto(Texto texto){
        if(texto != null){
            textosCadastrados.add(texto);
        }
    }
    
    
    public Collection<Texto> getTextosCadastrados(){
        return this.textosCadastrados;
    }
   
    
    public void setEstrategiaDeRecombinacaoAtual(Estrategia estrategia){
        if(estrategia != null){
            this.estrategia = estrategia;
        }
    }
    
    public void recombinar(){
        estrategia.aplicaEstrategia();
    }
    
    public Texto getTextoRecombinado(){
        return estrategia.getNovoTextoGerado();
    }
    
    public boolean podeRecombinar(){
        return estrategia.podeAplicarEstrategia();
    }
    
    public void aplicaRecombinacao(){
        estrategia.aplicaEstrategia();
    }
    
    public void salvaRecombinacaoAtual(){
       cadastraTexto(estrategia.getNovoTextoGerado()); 
    }
        
        
        
        
    
    
    
    
    
    
    
    public static Sistema getInstance(){
        if(sistemaInstance == null){
            sistemaInstance = new Sistema();
        }
        return sistemaInstance;
            
    }
    
    
    
    
}
