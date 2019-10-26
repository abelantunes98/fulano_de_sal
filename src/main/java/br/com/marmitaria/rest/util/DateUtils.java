package br.com.marmitaria.rest.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	
	public static String newDate() {
		format.setTimeZone(TimeZone.getTimeZone("America/Recife"));
		return format.format(new Date());
	}
	
	public static String newDate(Date date) {
		format.setTimeZone(TimeZone.getTimeZone("America/Recife"));
		return format.format(date);
	}

}
