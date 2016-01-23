package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StringFunc {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		GregorianCalendar gc = new GregorianCalendar();
		/*
		String to = "a";
		String[] x = to.split(",");
		for(String tmp: x){
			System.out.println(tmp);
		}
		Calendar startDate = new GregorianCalendar(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DAY_OF_MONTH),gc.get(Calendar.HOUR),0,0);
		startDate.add(Calendar.HOUR, 1);
		
		String startDateString = new SimpleDateFormat("yyyy-MM-dd HH").format(gc.getTime());
		String endDateString = new SimpleDateFormat("yyyy-MM-dd HH").format(gc.getTime());
		gc.setTime(startDate.getTime());
		
		System.out.println(gc.getTime());
		System.out.println(startDate.getTime());
		

		/*
		GregorianCalendar gc1 = new GregorianCalendar();
		Calendar startDate1 = new GregorianCalendar(gc1.get(Calendar.YEAR),gc1.get(Calendar.MONTH),gc1.get(Calendar.DAY_OF_MONTH),gc1.get(Calendar.HOUR),0,0);
		Calendar endDate = new GregorianCalendar(gc1.get(Calendar.YEAR),gc1.get(Calendar.MONTH),gc1.get(Calendar.DAY_OF_MONTH),gc1.get(Calendar.HOUR),0,0);
		endDate.add(Calendar.HOUR, 1);
		
		System.out.println(startDate1.getTime());
		System.out.print(endDate.getTime());
		
		Date dateForReport = new SimpleDateFormat("yyyy-MM-dd").parse("2015-12-14");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-02");
		
		gc.setTime(dateForReport);
		while(gc.getTime().after(endDate)){
			System.out.println(gc.getTime());
			gc.add(Calendar.DAY_OF_YEAR, -1);
			
		}
		*/
		
		String test = "个贷-西安-贷款类CZX-贷款-手机APP贷款";
		String test1 = "个贷-西安-贷款类CZX-贷款-手机app贷款";
		
		if(test1.toLowerCase().equals(test.toLowerCase())){
			System.out.println(-1);
		}
		
	}

}
