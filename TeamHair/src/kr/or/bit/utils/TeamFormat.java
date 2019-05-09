package kr.or.bit.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class TeamFormat {
	public static boolean iscellPhoneMetPattern(String cellPhoneNumber) {
		boolean isMet ;
		String pattern = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		isMet = Pattern.matches(pattern, cellPhoneNumber);
		return isMet;
	}
	
	public static String dateTimeFormat(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String dateTime=df.format(date);
		return dateTime;
		
	}
	
	public static String dateFormat(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateFormat=df.format(date);
		return dateFormat;
		
	}
	
	public static String amountFormat(int amount) {
		DecimalFormat df = new DecimalFormat("###,###");
		String amountFormat = df.format(amount);
		return amountFormat;
	}

}
