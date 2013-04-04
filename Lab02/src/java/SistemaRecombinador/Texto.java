/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaRecombinador;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Texto {
    
    private String texto;
    private String dataCriacao;

    public Texto(String texto) {
        this.texto = texto;
        SimpleDateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        this.dataCriacao = format.format(new Date());
    }

    public String getTexto() {
        return texto;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Texto){
            return this.texto.equals(((Texto)o).getTexto());
        }
        return false;
    }
    
    
    
    
    
    
    
    
}
