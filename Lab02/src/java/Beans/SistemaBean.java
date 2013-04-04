/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import SistemaRecombinador.EstrategiaAleatoriaComRepeticao;
import SistemaRecombinador.EstrategiaAleatoriaSemRepeticao;
import SistemaRecombinador.EstrategiaInvertida;
import SistemaRecombinador.Sistema;
import SistemaRecombinador.Texto;
import java.util.Collection;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Guilherme
 */
@SessionScoped
@ManagedBean(name="classe")
public class SistemaBean {

    private String mensagem;
    private Sistema sistema;
    private String texto;
    private String estrategia;
    
    public SistemaBean() {
        this.sistema = Sistema.getInstance();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    public String addTexto(){
        sistema.cadastraTexto(texto);
        this.texto = "";
        this.mensagem = "texto cadastrado com sucesso";
        return "index";
    }

    public String getMensagem() {
        String retorno = mensagem;
        this.mensagem = "";
        return retorno;
    }
    
    
    public Collection<Texto> getTextosCadastrados(){
        return sistema.getTextosCadastrados();
    } 
    
    
    
    public String recombinar(Texto texto){
        sistema.setTextoParaRecombinar(texto);
        sistema.setEstrategiaDeRecombinacaoAtual((estrategia.equals("Aleatoria com repeticao") ? new EstrategiaAleatoriaComRepeticao() : (estrategia.equals("Inversa") ? new EstrategiaInvertida() : new EstrategiaAleatoriaSemRepeticao())));
        return "recombinarTexto";
    }
    
    
    public Collection<String> getEstrategias(){
        Collection<String> estrategias = new LinkedList<String>();
        estrategias.add("Aleatoria sem repeticao");
        estrategias.add("Aleatoria com repeticao");
        estrategias.add("Inversa");
        return estrategias;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
    
    
    
    
    
}
