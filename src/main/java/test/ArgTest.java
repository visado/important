package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ArgTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		GregorianCalendar gc = new GregorianCalendar();
		Date time;
		
		if(args.length > 0){
			
			try {
				time = new SimpleDateFormat("yyyy-MM-dd").parse(args[0]);
	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				gc.add(5, -1);
				time = gc.getTime();
			}
		}
		else{
			gc.add(5,-1);
			time = gc.getTime();
		}
		
		System.out.println(time);
	}

}
