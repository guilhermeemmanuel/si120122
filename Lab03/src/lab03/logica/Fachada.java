/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.logica;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class Fachada {
    
    private static Fachada fachada;
    
    private ExecutorService service;
    
    private Collection<Observador> observadores;
    
    
    private Fachada(){
        this.observadores = new LinkedList<Observador>();
    }
    
    
    public void addObservador(Observador observador){
        if(observador != null){
            this.observadores.add(observador);
        }
        
    }
    
    
    
    public void realizaOperacao(String diretorio, int numeroThreads){
        this.service = Executors.newFixedThreadPool(numeroThreads);
        procuraArquivosJava(diretorio);
        opera(diretorio);
    }
    
    public void realizaOperacao(String diretorio){
        
        procuraArquivosJava(diretorio);
        this.service = Executors.newFixedThreadPool(BancoDeDados.getInstance().getArquivosLidos().size());
        opera(diretorio);
    }
    
    
    public void procuraArquivosJava(String diretorio){
        File file = new File(diretorio);
        if(file.exists()){
            System.out.println(diretorio);
            for (File arquivo : file.listFiles()) {
                if(arquivo.isFile()){
                    
                    try {
                        if(arquivo.getCanonicalPath().endsWith(".java")){
                            BancoDeDados.getInstance().addArquivoLido(arquivo.getCanonicalPath());
                            for (Observador observador : observadores) {
                                observador.avisaArquivoLido();
                            }
                        }
                    } catch (IOException ex) {
                    
                    }
                    
                }
                else{
                    try {
                        procuraArquivosJava(arquivo.getCanonicalPath());
                    } catch (IOException ex) {
                        
                    }
                }
                
                
                
            }
        }
        else{
            //jogar excecao
        }
    }
        
    
    public void opera(String diretorio){
        ((ThreadPoolExecutor) service).prestartAllCoreThreads();
        
        
        for (final String arquivo : BancoDeDados.getInstance().getArquivosLidos()) {
			Callable<Float> trabalho = new Callable<Float>(){
				@Override 
				public Float call() {
										
                                        BancoDeDados.getInstance().operaArquivo(arquivo);
                                        for (Observador observador : observadores) {
                                            observador.avisaArquivoLido();
                                        }
					return 42f;
				}
			};

			service.submit(trabalho);
		}

		service.shutdown();
        
        
        
    }
    
    
    
    public static Fachada getInstance(){
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }
    
    
    
    
    
}
