package microBlog.framework;

import java.net.MalformedURLException;



public final class LinksMicroblog {

    
        private Usuario usuario;
	
	
	public LinksMicroblog(){
                usuario = new Usuario("usuario","senha");
	}

	
	


	









	

    public String getLink(){
        return usuario.getLink(); 
    }


	public void addLink(String string) throws MalformedURLException {
            	
            usuario.addLink(string);
	}



	



	public String[] getTopTenLinks() {
		
		return usuario.getTopTenLinks();
		
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
