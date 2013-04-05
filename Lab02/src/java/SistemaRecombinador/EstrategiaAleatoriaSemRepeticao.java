/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class EstrategiaAleatoriaSemRepeticao implements Estrategia{

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
            LinkedHashSet<String> linhasDoTexto = new LinkedHashSet<String>();
            linhasDoTexto.addAll(textoARecombinar.getTexto());
            while(true){
                int valor = (int) (Math.random() * linhasDoTexto.size());
                if(valor > linhasDoTexto.size()){
                    valor = linhasDoTexto.size();
                }
            
                Object[] linhasDoTextoLista = linhasDoTexto.toArray();
                String linha = (String) linhasDoTextoLista[valor];
                if(!textoRecombinado.contains(linha)){
                    textoRecombinado.addLinha(linha);
                    break;
                }
                
            }
        }
    }

    @Override
    public Texto getNovoTextoGerado() {
        return textoRecombinado;
    }

    @Override
    public boolean podeAplicarEstrategia() {
        return textoRecombinado.numeroDeLinhas() < textoARecombinar.numeroDeLinhas();
    }
    
}
