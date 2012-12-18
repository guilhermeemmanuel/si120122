import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.dv.xs.TimeDV;


public class LinkTest {

	
	private Link link;
	
	@Before
	public void setUp() throws Exception {
		link = new Link();
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testaConstrutorSite() {
		
		String site = "ksdalsk";
		try{
			link = new Link(site);
			fail();
		}catch(MalformedURLException ex){
			//ok
		}
		
		site = "http//";
		try{
			link = new Link(site);
			fail();
		}catch(MalformedURLException ex){
			//ok
		}
		
		site = "http://";
		try{
			link = new Link(site);
			fail();
		}catch(MalformedURLException ex){
			
		}
		
		site = "https:";
		try{
			link = new Link(site);
			fail();
		}catch(MalformedURLException ex){
			
		}
		
		site = "https://";
		try{
			link = new Link(site);
			fail();
		}catch(MalformedURLException ex){
			
		}
		
		site = "https://a";
		try{
			link = new Link(site);
			
		}catch(MalformedURLException ex){
			fail();
		}
		
		
		site = "http://www.google.com";
		try{
			link = new Link(site);
			assertEquals(site, link.getLink());
		}catch(MalformedURLException ex){
			fail();
		}
		
		
	}
	
	//talvez esse teste seja desnecessario pois estou repetindo o codigo que foi feito na classe Link
	@Test
	public void testaHorarioDePublicacao() throws Exception{
		//esse teste pode dar errado se as datas forem criadas no limite dos minutos
		//mas mesmo assim o teste esta correto pois se as datas fossem criadas no mesmo instante daria certo
		//ai foi o erro de demora do computador
		assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), link.getPublicationDateString());
		link = new Link("https://www.google.com");
		assertEquals(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), link.getPublicationDateString());
		
	}
	
	@Test
	public void testaDiferencaDeHorariosDePublicacao() throws Exception{
		
		
		
		/*
		long tempo = (30000000000L * 5);
		
		for (long i = 0; i < tempo; i++) {
			
		}
		*/
		
		Link link2 = new Link();
		
		System.out.println(link.getDiferencaDeHorario(link2));
		System.out.println(link.getPublicationDateString());
		System.out.println(link2.getPublicationDateString());
		
		
		
		
		
		
	}
	
	
	@Test
	public void testaSitePrincipal() throws Exception{
		String site = "http://www.google.com";
		link = new Link(site);
		
		assertEquals("www.google.com",link.getSitePrincipal());
		
		site = "https://www.facebook.com";
		link.setLink(site);
		
		assertEquals("www.facebook.com",link.getSitePrincipal());
		
		site = "http://www.youtube.com/sdalksdakr/kjadsa";
		link.setLink(site);
		
		assertEquals("www.youtube.com",link.getSitePrincipal());
		
	}
	

}
