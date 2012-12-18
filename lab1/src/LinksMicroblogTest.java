import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LinksMicroblogTest {

	
	private static LinksMicroblog micro;
	
	
	
	
	@Before
	public void setUp(){
		try{
			micro = LinksMicroblog.getInstance();
		}catch(InstanciaUnicaExistenteException ex){
			
		}
	}

	@After
	public void tearDown() throws Exception {
	}
/*
	@Test
	public void testaConstrutor() {
		String nomeUsuario = "guilherme emmanuel";
		String senhaUsuario = "asdfasdf";
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			//ok
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		nomeUsuario = " ";
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			//ok
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		nomeUsuario = "";
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			//ok
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "";
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			//ok
		}
		
		senhaUsuario = "        ";
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			//ok
		}
		
		senhaUsuario = "shdga21Aasws";
		
		
		try{
			micro = new LinksMicroblog(nomeUsuario,senhaUsuario);
			
			assertTrue(micro.acessAccount(nomeUsuario,senhaUsuario));
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
	}
*/
	
	
	
	
	@Test
	public void testaUnicaInstancia(){
		
		
		
		
		
		try{
			micro = LinksMicroblog.getInstance();
			fail();
		}catch(InstanciaUnicaExistenteException ex){
		
		}
		
		
	}
	
	@Test
	public void testaAddUsuario(){
		
		String nomeUsuario = "";
		String senhaUsuario = "";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("nome do usuario nao pode ser vazio.", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		nomeUsuario = "guilherme emmanuel";
		senhaUsuario = "";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("nome do usuario nao pode conter espacos vazios.", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		
		nomeUsuario = "guilhermeemmanuel ";
		senhaUsuario = "";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("nome do usuario nao pode conter espacos vazios.", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			assertEquals("senha deve ter pelo menos 4 caracteres.", ex.getMessage());
		}
		
		
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "jhs";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			assertEquals("senha deve ter pelo menos 4 caracteres.", ex.getMessage());
		}
		
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "           ";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			assertEquals("senha nao pode estar toda em branco.", ex.getMessage());
		}
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "askdj ads";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		
		nomeUsuario = "guilhermeemmanuel";
		senhaUsuario = "askdasds";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			assertEquals("ja existe um usuario com este nome.", ex.getMessage());	
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		
		nomeUsuario = "guilhermeemmanuel2";
		senhaUsuario = "askdj ads";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
		}catch(UsuarioExistenteException ex){
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		
		nomeUsuario = "guilhermeemmanuel2";
		senhaUsuario = "askdasds";
		
		try{
			micro.addUsuario(nomeUsuario,senhaUsuario);
			fail();
		}catch(UsuarioExistenteException ex){
			assertEquals("ja existe um usuario com este nome.", ex.getMessage());	
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}
		
		
		
	}
	
	
	
	@Test
	public void fazerLoginELogoff(){
		
		String nomeUsuario = "skd";
		String senhaUsuario = "saaslkda";
		
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("Usuario com o nome skd nao encontrado", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
		
		nomeUsuario = "guiga";
		
		try{
			micro.addUsuario(nomeUsuario, senhaUsuario);
		}catch(Exception ex){
			fail();
		}
		
		nomeUsuario = "skd";
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("Usuario com o nome skd nao encontrado", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
		
		
		nomeUsuario = "guiga";
		senhaUsuario = "aaaa";
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			assertEquals("acesso negado pois a senha passada nao eh igual a senha do usuario.", ex.getMessage());
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
	
		
		nomeUsuario = "guiga12";
		
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			fail();
		}catch(NomeInvalidoException ex){
			assertEquals("Usuario com o nome guiga12 nao encontrado", ex.getMessage());
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
		
		
		
		assertEquals(null, micro.getNomeDoUsuarioDaContaAberta());
		
		try{
			micro.DesacessaConta();
			fail();
		}catch(NenhumaContaAcessadaException ex){
			assertEquals("nenhuma conta esta acessada no microblog.",ex.getMessage());
		}
		
		
		nomeUsuario = "guiga";
		senhaUsuario = "saaslkda";
		
		
		
		
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			assertEquals("guiga", micro.getNomeDoUsuarioDaContaAberta());
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
		
		
		try{
			micro.DesacessaConta();
			assertEquals(null, micro.getNomeDoUsuarioDaContaAberta());
		}catch(NenhumaContaAcessadaException ex){
			fail();
		}
		
		
		nomeUsuario = "guiga1";
		
		try{
			micro.addUsuario(nomeUsuario, senhaUsuario);
		}catch(Exception ex){
			fail();
		}
		
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
			assertEquals("guiga1", micro.getNomeDoUsuarioDaContaAberta());
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			fail();
		}
		
		nomeUsuario = "guiga";
		senhaUsuario = "saaslkda";
		
		try{
			micro.acessaConta(nomeUsuario,senhaUsuario);
		}catch(NomeInvalidoException ex){
			fail();
		}catch(SenhaInvalidaException ex){
			fail();
		}catch(JaExisteContaAcessadaException ex){
			assertEquals("ja existe uma conta acessada.", ex.getMessage());
		}
		
		
		
	}
	
	
	@Test
	public void testaLink(){
		
		
		try {
			micro.DesacessaConta();
		} catch (NenhumaContaAcessadaException e1) {
			
		}
		
		
		
		try {
			micro.addLink("http://www.google.com");
			fail();
		} catch (NenhumaContaAcessadaException ex) {
			assertEquals("nenhuma conta esta acessada no microblog.", ex.getMessage());
		} catch (MalformedURLException ex) {
			fail();
		}
		
		
		
		
		
		
		
			try {
				micro.addUsuario("guilhermeemmanueldesousaneves", "adsdasdas");
			} catch (UsuarioExistenteException e) {
				
			} catch (NomeInvalidoException e) {
				
			} catch (SenhaInvalidaException e) {
				
			}
		
			
			
			try {
				micro.acessaConta("guilhermeemmanueldesousaneves", "adsdasdas");
			} catch (NomeInvalidoException e) {
				
			} catch (SenhaInvalidaException e) {
				
			} catch (JaExisteContaAcessadaException e) {
				
			}
			
			
			
			try {
				micro.addLink("http://www.google.com");
			} catch (NenhumaContaAcessadaException ex) {
				fail();
			} catch (MalformedURLException ex) {
				fail();
			}	
			
			
			
			try {
				assertEquals("http://www.google.com", micro.getLinkDoTopo());
			} catch (NenhumaContaAcessadaException e) {
				fail();
			}	
			
			try {
				micro.DesacessaConta();
			} catch (NenhumaContaAcessadaException e1) {
				
			}
			
			
			try {
				micro.getLinkDoTopo();
				fail();
			} catch (NenhumaContaAcessadaException ex) {
				assertEquals("nenhuma conta esta acessada no microblog.", ex.getMessage());
			}
			
			
			
			
		
	}
	
	
	@Test
	public void testaTempo(){
		
		try {
			micro.DesacessaConta();
		} catch (NenhumaContaAcessadaException e1) {
			
		}
		
		try {
			micro.addUsuario("guilhermeemmanueldesousaneves", "adsdasdas");
		} catch (UsuarioExistenteException e) {
			
		} catch (NomeInvalidoException e) {
			
		} catch (SenhaInvalidaException e) {
			
		}
	
		
		
		try {
			micro.acessaConta("guilhermeemmanueldesousaneves", "adsdasdas");
		} catch (NomeInvalidoException e) {
			
		} catch (SenhaInvalidaException e) {
			
		} catch (JaExisteContaAcessadaException e) {
			
		}
		
		
		
		//falta testar
		//ate aqui n testei nada ainda
		
		
		
		
	}
	
	
}
