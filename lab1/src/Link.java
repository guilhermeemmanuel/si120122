import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

//eu pensei em estender a classe URL, mas a classe URL eh final e nao pode ser estendida
//:L
public class Link {

	private URL link;
	private String data;
	
	public Link() throws MalformedURLException{
		//aqui devo colocar o site do sistema ou mandar sempre  excecao pois nao pode criar link vazio talvez 
		this.link = new URL("http://");
		this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
	}
	
	
	public Link(String link) throws MalformedURLException {
		
		this.link = new URL(link);
		this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		char[] dividido = this.link.toString().toCharArray();
		int tamanhoMinimo = 6;
		if(dividido[4] == 's'){
			tamanhoMinimo++;
		}
		if(dividido.length >= tamanhoMinimo){
			//ok
		}
		else{
			throw new MalformedURLException();
		}
		/*
		int pos = 6;
		if(dividido[4] == ':'){
			pos--;
		}
		if((dividido[pos] == '/') && (dividido[pos + 1] == '/')){
			if(dividido.length >= pos + 3){
				//ok
			}
			else{
				throw new MalformedURLException();
			}
		}
		else{
			throw new MalformedURLException();
		}
		*/
	}


	public String getLink() {
		return link.toString();
	}


	public void setLink(String link) throws MalformedURLException{
		this.link = new URL(link);
	}


	
	public String getPublicationDateString() {
		return this.data;
	
	}

	public Date getPublicationDate(){
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try{
			return sf.parse(this.data);
		}catch(ParseException ex){
			return null;
		}
	}

	public String getDiferencaDeHorario(Link link2) {
		
		
		long tempoDiferenca = this.getPublicationDate().getTime() - link2.getPublicationDate().getTime();;
		if(tempoDiferenca < 0L){
			tempoDiferenca *= -1;
		}
		long anos = ((long)(tempoDiferenca/(12*31*24*60*60*1000)));
		long resto = (tempoDiferenca - (anos * (12*31*24*60*60*1000) ) );
		long meses = ((long)( resto /(31*24*60*60*1000)));
		resto = (resto - (meses * (31*24*60*60*1000) ) );
		long dias = ((long)( resto /(24*60*60*1000)));
		resto = (resto - (dias * (24*60*60*1000) ) );
		long horas = ((long)( resto /(60*60*1000)));
		resto = (resto - (horas * (60*60*1000) ) );
		long minutos = ((long)( resto /(60*1000)));
		resto = (resto - (minutos * (60*1000) ) );
		long segundos = ((long)( resto /(1000)));
		
		String diferenca = "" + anos + "." + meses + "." + dias + " " + horas + ":" + minutos + ":" + segundos;
		return diferenca;
	}


	public String getSitePrincipal() {
		String[] partes = this.link.toString().split("/");
		return partes[2];
	}


	




	

	
	
	
	
	
	
	
	
	
	
	
}
