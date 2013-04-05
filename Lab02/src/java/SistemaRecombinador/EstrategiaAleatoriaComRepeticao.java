/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 *
 * @author Guilherme
 */
public class EstrategiaAleatoriaComRepeticao implements Estrategia{

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
            
            int valor = (int) (Math.random() * linhasDoTexto.size());
            if(valor > linhasDoTexto.size()){
                    valor = linhasDoTexto.size();
            }
            
                Object[] linhasDoTextoLista = linhasDoTexto.toArray();
                String linha = (String) linhasDoTextoLista[valor];
                textoRecombinado.addLinha(linha);
                    
                
                
            
        }
    }

    @Override
    public Texto getNovoTextoGerado() {
        return textoRecombinado;
    }

    @Override
    public boolean podeAplicarEstrategia() {
        return true;
    }
    
}
