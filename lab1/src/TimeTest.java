import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TimeTest {

	Time time;
	
	@Before
	public void setUp() throws Exception {
		time = new Time();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		GregorianCalendar gCal = (GregorianCalendar) GregorianCalendar.getInstance();
		System.out.println(gCal.getTime());
		gCal.add(GregorianCalendar.DATE, 10);
		System.out.println(gCal.getTime());
		
	}

}
