package microBlog.framework;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



public final class LinksMicroblog {
	
	private static boolean hasInstance = false;
	private Set<Usuario> usuarios;
	private Usuario usuarioAberto;
	
	
	private LinksMicroblog(){
		alteraInstancia();
		usuarios = new TreeSet<Usuario>();
	}

	
	private static void alteraInstancia(){
		hasInstance = true;
	}


	public static LinksMicroblog getInstance() throws InstanciaUnicaExistenteException {
		if(!hasInstance){
			return new LinksMicroblog();
		}
		else{
			throw new InstanciaUnicaExistenteException("ja existe uma instancia do microblog de links");
		}
	}



	public void addUsuario(String nomeUsuario, String senhaUsuario) throws UsuarioExistenteException,NomeInvalidoException,SenhaInvalidaException {
		
		
		boolean adicionou = usuarios.add(new Usuario(nomeUsuario, senhaUsuario));
		if(!adicionou){
			throw new UsuarioExistenteException("ja existe um usuario com este nome.");
		}
		
	}



	public void acessaConta(String nomeUsuario, String senhaUsuario) throws NomeInvalidoException, SenhaInvalidaException, JaExisteContaAcessadaException {
		if(usuarioAberto != null){
			throw new JaExisteContaAcessadaException("ja existe uma conta acessada.");
		}
		Iterator<Usuario> iterator = usuarios.iterator();
		while (iterator.hasNext()) {
			Usuario user= iterator.next();
			try{
				user.validarAcesso(nomeUsuario,senhaUsuario);
			}catch(NomeInvalidoException ex){
				continue;
			}
			this.usuarioAberto = user;
			return;
		}
		throw new NomeInvalidoException("Usuario com o nome " + nomeUsuario + " nao encontrado");
		
	}



	
	
	public String getNomeDoUsuarioDaContaAberta() {
		if(usuarioAberto == null)
			return null;
		return usuarioAberto.getNome();
		
	}



	public void DesacessaConta() throws NenhumaContaAcessadaException{
		if(usuarioAberto == null){
			throw new NenhumaContaAcessadaException("nenhuma conta esta acessada no microblog.");
		}
		usuarioAberto = null;
		
	}



	public void addLink(String string) throws NenhumaContaAcessadaException,MalformedURLException {
		if (usuarioAberto == null) {
			throw new NenhumaContaAcessadaException("nenhuma conta esta acessada no microblog.");
		}
		usuarioAberto.addLink(string);
	}



	public String getLinkDoTopo() throws NenhumaContaAcessadaException {
		if(usuarioAberto == null){
			throw new NenhumaContaAcessadaException("nenhuma conta esta acessada no microblog.");
		}
		return usuarioAberto.getLinkDoTopo();
	}



	public String[] getTopTenLinks() throws NenhumaContaAcessadaException{
		if(usuarioAberto == null){
			throw new NenhumaContaAcessadaException("nenhuma conta esta acessada no microblog.");
		}
		return usuarioAberto.getTopTenLinks();
		
	}


	
	
/*
	Set<Usuario> usuarios;
	List<Link> links;

	

	private LinksMicroblog(){
		
	}

	public LinksMicroblog(String nomeUsuario, String senhaUsuario) throws NomeInvalidoException,SenhaInvalidaException {
		
		
	}

	public boolean acessAccount(String nomeUsuario, String senhaUsuario) {
		return false;
	}

	
	*/
}
