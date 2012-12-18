import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;


public class Usuario implements Comparable<Usuario> {

	private String nome;
	private String senha;
	private List<Link> links;
	
	
	public Usuario(String nomeUsuario, String senhaUsuario) throws NomeInvalidoException,SenhaInvalidaException{
		if(nomeUsuario.indexOf(" ") != -1){
			throw new NomeInvalidoException("nome do usuario nao pode conter espacos vazios.");
		}
		if(nomeUsuario.length() < 1){
			throw new NomeInvalidoException("nome do usuario nao pode ser vazio.");
		}
		if(senhaUsuario.length() < 4){
			throw new SenhaInvalidaException("senha deve ter pelo menos 4 caracteres.");
		}
		boolean senhaEmBranco = true;
		for (char ch : senhaUsuario.toCharArray()) {
			if(ch != ' '){
				senhaEmBranco = false;
				break;
			}
		}
		if(senhaEmBranco){
			throw new SenhaInvalidaException("senha nao pode estar toda em branco.");
		}
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


	public void validarAcesso(String nomeUsuario, String senhaUsuario) throws NomeInvalidoException, SenhaInvalidaException {
		if(!getNome().equals(nomeUsuario)){
			throw new NomeInvalidoException("acesso negado pois o nome passado nao eh igual ao nome do usuario.");
		}
		if(!getSenha().equals(senhaUsuario)){
			throw new SenhaInvalidaException("acesso negado pois a senha passada nao eh igual a senha do usuario.");
		}
		
	}


	public String getLinkDoTopo() {
		return links.get(0).getLink();
	}


	public void addLink(String string) throws MalformedURLException {
		links.add(new Link(string));
	}


	public String[] getTopTenLinks() {
		Link[] fatia = (Link[])links.subList(0, 9).toArray();
		String[] topTen = new String[10];
		int posicao = 0;
		for (Link link : fatia) {
			topTen[posicao] = link.getLink();
			posicao++;
		}
		return topTen;
	}





	

	

	
	
}
