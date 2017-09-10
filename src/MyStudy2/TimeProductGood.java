package MyStudy2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeProductGood {
	
	private String name;

	
	static Calendar calendar = new GregorianCalendar();
	
	static int year = calendar.get(Calendar.YEAR);
	static int second = calendar.get(Calendar.SECOND);

	private String yearsecond = Integer.toString(year) + "≥‚" + Integer.toString(second) + "√ ";
	
	public TimeProductGood(String name) {
		this.name = yearsecond;
			
	}
	
	public String getName() {
		return yearsecond;
	}
	
	public void setName(String name) {
		this.name = yearsecond;
	}
		
}
