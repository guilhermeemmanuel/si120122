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
public class EstrategiaInvertida implements Estrategia{

    private Texto textoARecombinar;
    private Texto textoRecombinado;
    
    @Override
    public void setTextoPrincipal(Texto texto) {
        this.textoARecombinar = texto;
        textoRecombinado = new Texto();
    }

    @Override
    public void aplicaEstrategia() {
        if(podeAplicarEstrategia()){
            Collection<String> linhasDoTexto = new LinkedList<String>();
            linhasDoTexto.addAll(textoARecombinar.getTexto());
            
                
               
                Object[] linhasDoTextoLista = linhasDoTexto.toArray();
                for(int i = linhasDoTextoLista.length - 1;i > -1; i-- ){
                    String linha = (String) linhasDoTextoLista[i];
                    textoRecombinado.addLinha(linha);
                    
                
                }
                
            
        }
    }

    @Override
    public Texto getNovoTextoGerado() {
        return this.textoRecombinado;
    }

    @Override
    public boolean podeAplicarEstrategia() {
        return textoRecombinado.numeroDeLinhas() < textoARecombinar.numeroDeLinhas();
    }
    
}
