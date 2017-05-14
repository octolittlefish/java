package javabean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	
	String BookId;
	String ReaderId;
	String ReaderName;
	String BookName;
    String StartTime;
    String ExpectReturnTime;
    String DebtDays;
    String Contact;

	public static void main(String[] args) {
		ReserveMessage e = new ReserveMessage("2121","12121","YGYG","WQWQWQ","WQWQWQ","WQWQWQ");
		System.out.println(e.toString());
	}
	

	public static String getTimeByHour(int hour) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}
}
