/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class BancoDeDados {
    
    private static BancoDeDados banco;
    
    private Map<String,Integer> mapaDePalavarasReservadas;
    
    private final String[] palavrasChave = {"abstract", "continue", "for", "new", "switch",
        "assert" ,     "default"   ,  "if"        ,    "package"   ,   "synchronized",
        "boolean" ,    "do"       ,   "goto"       ,   "private"   ,   "this",
        "break"    ,   "double"   ,   "implements"  ,  "protected" ,   "throw",
        "byte"      ,  "else"     ,   "import"     ,   "public"    ,   "throws",
        "case"     ,   "enum"     ,   "instanceof"  ,  "return"    ,   "transient",
        "catch"    ,   "extends"  ,   "int"         ,  "short"     ,   "try",
        "char"     ,   "final"    ,   "interface"   ,  "static"   ,    "void", 
        "class"    ,   "finally"  ,   "long"        ,  "strictfp" ,    "volatile",
        "const"    ,   "float"   ,    "native"      ,  "super"   ,     "while" };
    
    
    private Collection<String> arquivosLidos;
    private int numeroArquivosLidos;
    private Lock lock;
    
    private BancoDeDados(){
        resetValues();
        this.lock = new ReentrantLock();
    }
    
    
    
    public void resetValues(){
        this.mapaDePalavarasReservadas = new HashMap<String, Integer>();
        for (String keyWord : palavrasChave) {
            this.mapaDePalavarasReservadas.put(keyWord, 0);
        }
        this.arquivosLidos = new LinkedList<String>();
        
        
    }
    
    
    /*
    public void addValues(Map<String,Integer> valoresParaAdicionar){
        for (String keyWord : valoresParaAdicionar.keySet()) {
            if(this.mapaDePalavarasReservadas.containsKey(keyWord)){
                this.mapaDePalavarasReservadas.put(keyWord, mapaDePalavarasReservadas.get(keyWord) + valoresParaAdicionar.get(keyWord));
            }
        }
    }
    */
    
    
    public static BancoDeDados getInstance(){
        
        if(banco == null){
            banco = new BancoDeDados();
        }
        return banco;
        
    }
    
    
    
    public Object[][] getResumo(){
        lock.lock();
        try{
            Object[][] resumo = new Object[palavrasChave.length][2];
            int i = 0;
            for (String string : palavrasChave) {
                resumo[i][0] = string;
                resumo[i][1] = this.mapaDePalavarasReservadas.get(string);
                i++;
            }
            return resumo;
        }finally{
            lock.unlock();
        }
        
      
    }
    
    
    public void addArquivoLido(String caminho){
        lock.lock();
        try{
            this.arquivosLidos.add(caminho);
        }finally{
            lock.unlock();
        }
    }
    
    
    public Collection<String> getArquivosLidos(){
        lock.lock();
        try{
        return this.arquivosLidos;
        }finally{
            lock.unlock();
        }
    }
    
    
    public void operaArquivo(String diretorio){
        lock.lock();
        try {
            BufferedReader rd = new BufferedReader(new FileReader(diretorio));
            String textoCompleto = "";
            
            while(rd.ready()){
                textoCompleto += " " + rd.readLine();
                    
            }
            //System.out.println(textoCompleto);
            
            String[] palavras = textoCompleto.split("\\W");
            for (String string : palavras) {
                if(this.mapaDePalavarasReservadas.containsKey(string)){
                    this.mapaDePalavarasReservadas.put(string, this.mapaDePalavarasReservadas.get(string) + 1);
                }
            }
            
            this.numeroArquivosLidos++;
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
                
        } finally {
            lock.unlock();
        }
        
        
       
    }

    public int getNumeroArquivosLidos() {
        lock.lock();
        try{
            return numeroArquivosLidos;
        } finally{
            lock.unlock();
        }
    }
    
    
    
    
    
    

        
    
        
    
    
    
    
}
