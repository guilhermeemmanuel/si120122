/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

/**
 *
 * @author Guilherme
 */
public interface Estrategia {
    
    public boolean podeAplicarEstrategia();
    public void setTextoPrincipal(Texto texto);
    public void aplicaEstrategia();
    public Texto getNovoTextoGerado();
    
}
