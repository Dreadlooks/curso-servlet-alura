package br.com.alura.generator.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	public static Calendar getCalendarFromString(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try {
			Date date = sdf.parse(dateString);

			return getCalendarFromDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public static Calendar getCalendarFromDate(Date date) {
		Calendar parsedDate = Calendar.getInstance();
		parsedDate.setTime(date);
		return parsedDate;
	}
}
