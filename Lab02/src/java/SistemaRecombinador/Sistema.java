/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Guilherme
 */
public class Sistema {
    
    private static Sistema sistemaInstance;
    private Collection<Texto> textosCadastrados;
    private Texto recombinar;
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
        
    
    
    public Collection<Texto> getTextosCadastrados(){
        return this.textosCadastrados;
    }
    
    public void setTextoParaRecombinar(Texto texto){
        if(textosCadastrados.contains(texto)){
            this.recombinar = texto;
        }
        
    }
    
    public void setEstrategiaDeRecombinacaoAtual(Estrategia estrategia){
        if(estrategia != null){
            this.estrategia = estrategia;
        }
    }
        
        
        
    
    
    
    
    
    
    
    public static Sistema getInstance(){
        if(sistemaInstance == null){
            sistemaInstance = new Sistema();
        }
        return sistemaInstance;
            
    }
    
    
    
    
}
