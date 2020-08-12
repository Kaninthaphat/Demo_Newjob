package general;

import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class DateTime {
	public static String getDateNow() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String dmy = df.format(now);
		int year = Integer.valueOf(dmy.substring(6, 10)).intValue();
		return (dmy.substring(0, 2) + "-" + dmy.substring(3, 5) + "-" + year);
	}
	
	public static String convert_YYYYMMDD(String StrDate) { //dd-MM-YYYY To DD-MM-YYYY
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(8,10)+ "-" + StrDate.substring(5,7) + "-" + StrDate.substring(0,4));
	}
	
	public static String convertYYYY(String StrDate) { //dd-MM-YYYY To YYYY
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return StrDate.substring(6,10);
	}
	
	public static String convertDDMMYY(String StrDate) { //dd-MM-YYYY To DDMMYY
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(0,2) + StrDate.substring(3,5) + StrDate.substring(8,10));
	}
	
	public static String convertThai(String StrDate) { //dd-MM-YYYY
		return (StrDate.substring(8,10) +"-"+ StrDate.substring(5,7) +"-"+ StrDate.substring(0,4));
	}
	
	public static String getDateNowEN() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String dmy = df.format(now);
		int year = Integer.valueOf(dmy.substring(6, 10)).intValue();
		return (year + "-" + dmy.substring(3, 5) + "-" + dmy.substring(0, 2));
	}
	
	public static String getAddDateNow(String xDate,String toDate) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = toDate;
		Date date = sdf.parse(dateInString);
		
		DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
		
		Calendar c = Calendar.getInstance(); 

		c.setTime(date);
		c.add(Calendar.DATE, Integer.parseInt( xDate ) );

		return dateFormat.format(c.getTime()); 
	}
	
	public static String getSubDateNow(String xDate,int toDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = xDate;
		Date date = sdf.parse(dateInString);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c = Calendar.getInstance(); 

		c.setTime(date);
		c.add(Calendar.DATE, -toDate );
		
		return dateFormat.format(c.getTime()); 
	}
	
	public static String getDateNow(String StrFormat) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat(StrFormat);
		String dmy = df.format(now);
		int year = Integer.valueOf(dmy.substring(6, 10)).intValue();
		return (dmy.substring(0, 2) + "-" + dmy.substring(3, 5) + "-" + year);
	}
	
	public static String getDate(String StrFormat) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat(StrFormat);
		return df.format(now);
	}
	
	public static String getYearNow() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(now);
	}
	
	public static String getTimeNow() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");	
		return df.format(now);
	}
	
	public static String getTimeMilliSecondNow() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss:SSS a,z");	
		return df.format(now);
	}
	
	//not sure
	public static String getDateTimeNow() {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dmy = df.format(now);
		int year = Integer.valueOf(dmy.substring(6, 10)).intValue();
		return (dmy.substring(0, 2) + "-" + dmy.substring(3, 5) + "-" + year + dmy.substring(10, 19));
	}
	
	public static String getDate_Format(String StrFormat) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat(StrFormat);
		return df.format(now);
	}
	
	public static String convertMMYYYY(String StrDate) { //dd-MM-YYYY To YYYYMM
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(3,5)+"/"+StrDate.substring(6,10));
	}
	
	public static String convertDate(String StrDate) { //dd-MM-YYYY To YYYY-MM-dd
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(6,10) +"-"+StrDate.substring(3,5)+"-"+StrDate.substring(0,2));
	}

	public static String convertDateTime(String StrDate) { //dd-MM-YYYY HH:mm:ss To YYYY-MM-dd HH:mm:ss
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(6,10) +"-"+StrDate.substring(3,5)+"-"+StrDate.substring(0,2) + " " + StrDate.substring(11,19) );
	}
	
	public static String convertYYYYMM(String StrDate) { //dd-MM-YYYY To YYYYMM
		//int IntYear = Integer.valueOf(StrDate.substring(6,10));
		return (StrDate.substring(6,10) + StrDate.substring(3,5));
	}
	
	public static float convertTimeToFloat(String strTime) {
		if (strTime.length() == 5) { // Format HH:MM
			int IntHH = Integer.valueOf(strTime.substring(0, 2)).intValue();
			int IntMM = Integer.valueOf(strTime.substring(3, 5)).intValue();
			return (float) (((IntHH * 60) + IntMM) * 0.000694443333);
		} else {
			return 0f;
		}
	}

	public static String nextDate(String date, int d, String Format) {
		if(d < 2)
			return convertDate(date); 
		else
			d-=1;
		
		for (int i = 0; i < d; i++)
			date = next(date);
		
		if(Format.equals("yyyy-mm-dd"))
			return convertDate(date);
		else
			return date;
		
	}

	static String next(String Date) {
		int d = Integer.valueOf(Date.substring(0, 2)).intValue();
		int m = Integer.valueOf(Date.substring(3, 5)).intValue();
		int y = Integer.valueOf(Date.substring(6, 10)).intValue();

		int dt = 0;

		if (m == 4 || m == 6 || m == 9 || m == 11) {
			dt = 30;
		} else if (m == 2) {
			dt = leapYear(y);
		} else {
			dt = 31;
		}

		if (d < dt) {
			d++;
		} else {
			if (d == dt) {
				d = 1;
				m++;
				if (m > 12) {
					m = 1;
					y++;
				}
			}
		}

		if (d < 10 && m < 10)
			return ("0" + d + "-0" + m + "-" + y);
		else if (d < 10 && m > 9)
			return ("0" + d + "-" + m + "-" + y);
		else if (d > 9 && m < 10)
			return (d + "-0" + m + "-" + y);
		
		
		return (d + "-" + m + "-" + y);
	}

	
	public static String getLastDay(int xMonth,int xYear,String StrFormat){
		int d = 1;
		switch(xMonth){
			case 2:	if ((xYear % 4 == 0) && (xYear % 100 != 0) ){
						d = 29;
					}else{
						d = 28;
					}

		}
		d = 1;
		//Date now = new Date();
		//SimpleDateFormat df = new SimpleDateFormat(StrFormat);
		return  ""+d; //df.format(now);
	}
	
	static int leapYear(int theYear) {
		if (theYear < 100) {
			if (theYear > 40) {
				theYear += 1900;
			} else {
				theYear += 2000;
			}
		}

		if (theYear % 4 == 0) {
			if (theYear % 100 != 0) {
				return 29;
			} else if (theYear % 400 == 0) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 28;
		}
	}
	
	public static String getDateLastMonth(){
		try{
			String StrDate = getDateNow();
			int y = Integer.valueOf(StrDate.substring(6, 10)).intValue();
			int m = Integer.valueOf(StrDate.substring(3, 5)).intValue();
			int d = Integer.valueOf(StrDate.substring(0, 2)).intValue();
			int dt = 0;
			
			if(m == 1){
				m = 12;
				y -= 1;
			}else{
				m -= 1;
			}
			
			if (m == 4 || m == 6 || m == 9 || m == 11) {
				dt = 30;
			} else if (m == 2) {
				dt = leapYear(y);
			} else {
				dt = 31;
			}
			
			if(d > dt){
				d = 1;
				m += 1;
			}
			
			return (d > 9 ? d : ("0"+d)) + "-" + (m > 9 ? m : ("0"+m)) + "-" + y; 
		}catch(Exception e){ 
			return "";
		}
	}
	
	public static String getMonthTH(String StrDate) { //MM
		int IntMonth = Integer.valueOf(StrDate.substring(3,5));
		String MonthTH = "";
		switch(IntMonth){
			case 1: MonthTH = "1";break;
			case 2: MonthTH = "2";break;
			case 3: MonthTH = "3";break;
			case 4: MonthTH = "4";break;
			case 5: MonthTH = "5";break;
			case 6: MonthTH = "6";break;
			case 7: MonthTH = "7";break;
			case 8: MonthTH = "8";break;
			case 9: MonthTH = "9";break;
			case 10: MonthTH = "10";break;
			case 11: MonthTH = "11";break;
			case 12: MonthTH = "12";break;
		}
		return MonthTH + " " + StrDate.substring(6,10);
	}
	
	public static String FormatThai(String StrDate) { 
		int IntYear = Integer.valueOf(StrDate.substring(6,10))+543;
		int Month = Integer.valueOf(StrDate.substring(3,5));
		String sMonth = null;
		switch( Month ){
			case 1:sMonth = "1";
				break;
			case 2:sMonth = "2";
				break;
			case 3:sMonth = "3";
				break;
			case 4:sMonth = "4";
			break;
			case 5:sMonth = "5";
			break;
			case 6:sMonth = "6";
			break;
			case 7:sMonth = "7";
			break;
			case 8:sMonth = "8";
			break;
			case 9:sMonth = "9";
			break;
			case 10:sMonth = "10";
			break;
			case 11:sMonth = "11";
			break;
			case 12:sMonth = "12";
			break;
		}
		return (StrDate.substring(0,2) +"       "+sMonth+"       "+IntYear );
	}
	
	@SuppressWarnings("deprecation")
	public static String set_DateString(Date s_Date){
		
		//Format YYYYddmm
	
		String dd = "";
		String mm = "";
		int yy = s_Date.getYear()-100;
		
		if((s_Date.getMonth()+1) < 10){
			mm = "0"+(s_Date.getMonth()+1);
		}else{
			mm = (s_Date.getMonth()+1)+"";
		}
		if(s_Date.getDate() < 10){
			dd = "0"+s_Date.getDate();
		}else{
			dd = s_Date.getDate()+"";
		}
		
		return  "20"+yy+mm+dd;
			
	}
	
	@SuppressWarnings("deprecation")
	public static String set_DateString_f2(Date s_Date){
		
		//Format YYYYddmm
	
		String dd = "";
		String mm = "";
		int yy = s_Date.getYear()-100;
		
		if((s_Date.getMonth()+1) < 10){
			mm = "0"+(s_Date.getMonth()+1);
		}else{
			mm = (s_Date.getMonth()+1)+"";
		}
		if(s_Date.getDate() < 10){
			dd = "0"+s_Date.getDate();
		}else{
			dd = s_Date.getDate()+"";
		}
		
		return  "20"+yy+"/"+mm+"/"+dd;
			
	}
	
	@SuppressWarnings("deprecation")
	public static String set_DateString_f3(Date s_Date){
		
		//Format dd-mm-YYYY
	
		String dd = "";
		String mm = "";
		int yy = s_Date.getYear()-100;
		
		if((s_Date.getMonth()+1) < 10){
			mm = "0"+(s_Date.getMonth()+1);
		}else{
			mm = (s_Date.getMonth()+1)+"";
		}
		if(s_Date.getDate() < 10){
			dd = "0"+s_Date.getDate();
		}else{
			dd = s_Date.getDate()+"";
		}
		
		return  dd+"-"+mm+"-"+"20"+yy;
			
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static String set_DateString_f4(Date s_Date){
		
		//Format dd-mm-YYYY
	
		String dd = "";
		String mm = "";
		int yy = s_Date.getYear()-100;
		
		if((s_Date.getMonth()+1) < 10){
			mm = "0"+(s_Date.getMonth()+1);
		}else{
			mm = (s_Date.getMonth()+1)+"";
		}
		if(s_Date.getDate() < 10){
			dd = "0"+s_Date.getDate();
		}else{
			dd = s_Date.getDate()+"";
		}
		
		return  dd+"/"+mm+"/"+"20"+yy;
			
	}
	
}
