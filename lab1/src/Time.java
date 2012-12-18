import java.util.Date;
import java.util.GregorianCalendar;


public class Time {

	String tempo;
	
	
	public Time() {
		this.tempo = "0000.00.00 00:00:00";
	}
	
	
	public Time(Date data1,Date data2) {
		this.tempo = this.getTimeInMiddle(data1, data2).getFormattedTime();
	}
	
	private Time(String dataFormatada){
		this.tempo = dataFormatada;
	}
	
	
	
	public String getFormattedTime() {
		
		return tempo;
	}


	public static Time getTimeInMiddle(Date data1, Date data2){
		Date dataMaior;
		Date dataMenor;
		if (data1.after(data2)) {
			dataMaior = data1;
			dataMenor = data2;
		}
		else{
			dataMaior = data1;
			dataMenor = data2;
		}
		int vai = 0;
		int vem = 0;
		String dataFormatada = "";
		/*
		if(data1.getSeconds() > data2.getSeconds()){
			vai = 60;
		}
		else{
			vai = 0;
		}
		
		dataFormatada = ":" + (data1.getSeconds() + vai - data2.getSeconds());
		if(vai == 60){
			vem = 1;
		}
		else{
			vem = 0;
		}
		
		*/
		
		
		
		
		
		
		
		//new GregorianCalendar().
		
		return null;
	}
	
	
}
