package microBlog.framework;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;


public class Usuario implements Comparable<Usuario> {

	private String nome;
	private String senha;
	private List<Link> links;
	
	
	public Usuario(String nomeUsuario, String senhaUsuario){
		
		this.nome = nomeUsuario;
		this.senha = senhaUsuario;
		links = new LinkedList<Link>();
                
	}

	
	@Override
	public int compareTo(Usuario usuario) {
		return getNome().compareTo(usuario.getNome());
	}


	public String getNome() {
		return nome;
	}
	
	private String getSenha() {
		return senha;
	}




	


	public void addLink(String string) throws MalformedURLException {
		links.add(0,new Link(string));
	}

        public String getLink(){
            try{
                return links.get(0).getLink();
            }catch(Exception ex){
                return "";
            }
        }
        
        
	public String[] getTopTenLinks() {
		
                String[] topTen = new String[10];
                try{
                topTen[0] = links.get(0).getLink();
                topTen[1] = links.get(1).getLink();
                topTen[2] = links.get(2).getLink();
                topTen[3] = links.get(3).getLink();
                topTen[4] = links.get(4).getLink();
                topTen[5] = links.get(5).getLink();
                topTen[6] = links.get(6).getLink();
                topTen[7] = links.get(7).getLink();
                topTen[8] = links.get(8).getLink();
                topTen[9] = links.get(9).getLink();
                }catch(Exception ex){
                    
                }
		return topTen;
	}





	

	

	
	
}
