/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.logica;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class BancoDeDadosTest {
    
    
    private BancoDeDados bd;
    
    public BancoDeDadosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bd = BancoDeDados.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void teste(){
        
        //este jfilechooser pega apenas um arquivo enquanto o que roda no projeto pega um diretorio
        //coloque no jfilechooser o caminho do teste.java que esta na raiz do projeto
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        jf.setVisible(true);
        jf.showOpenDialog(null);
        File diretorio = jf.getSelectedFile();
        String dir = null;
        try {
            dir = diretorio.getCanonicalPath();
            bd.addArquivoLido(dir);
        
        } catch (IOException ex) {
            
        }
        
        Assert.assertEquals(1, bd.getArquivosLidos().size(), 0.01);
        
        bd.operaArquivo(dir);

        Object[][] resumo = bd.getResumo();
        for (int i = 0; i < resumo.length;i++) {
            if(resumo[i][0].equals("public")){
                Assert.assertEquals(2, (Integer)resumo[i][1],0.01);
            }
            if(resumo[i][0].equals("new")){
                Assert.assertEquals(1, (Integer)resumo[i][1],0.01);
            }
            if(resumo[i][0].equals("protected")){
                Assert.assertEquals(0, (Integer)resumo[i][1],0.01);
            }
        }
        
        
    }
    
}
