package generic_Utility;

import java.sql.Date;
import java.util.Random;

/**
 * This Class Contains Methods Related to java
 */
public class Java_Utility {
	/**
	 * This Method is uesd to Generate random Number
	 * @return
	 */
	public int toGetRandomNumber() {
		Random rs = new Random();
		int value = rs.nextInt(1000);
		return value;
	}
	/**
	 * This Method is used To take the Date and Time of The System 
	 * @return
	 */
	public String toGetSystemdateandtime() {
		
	  java.util.Date ds = new java.util.Date();
	  String[] date =ds.toString().split("");
	  String day = date[0];
	  String month = date[1];
	  String date1 = date[2];
	  String time = date[3].replace(";", "-");
	  String year = date[5];
	  String finldate = day+" "+month+" "+date1+" "+time+" "+year;
	   return finldate;
	}

}
