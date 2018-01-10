package com.mlsd.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ummalqura.calendar.UmmalquraCalendar;

/**
 * A Utilities class for static functions that is used among the classes.
 * 
 * @author Ahmed Sharaf
 *
 */
public class Utilities {

	private Utilities() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	/**
	 * 
	 * @param hijriDate
	 *            : A hijri date that needs to be converted to gregorian date.
	 * @return the resulting Gregorian date.
	 */
	public static Calendar getGregorianDateFromHijriDate(Calendar hijriDate) {
		int hijriYear = hijriDate.get(Calendar.YEAR);
		int hijriMonth = hijriDate.get(Calendar.MONTH);
		int hijriDay = hijriDate.get(Calendar.DAY_OF_MONTH);
		return new UmmalquraCalendar(hijriYear, hijriMonth, hijriDay);
	}

	/**
	 * 
	 * @param gregorianDate
	 *            : A gregorian date that needs to be coverted to a hijri date.
	 * @return the resulting Hijri date.
	 */
	public static Calendar getHijriDateFromGregorianDate(Calendar gregorianDate) {
		Calendar gregorian = gregorianDate;
		if (gregorian == null) {
			gregorian = Calendar.getInstance();
		}
		Calendar cal = new UmmalquraCalendar();
		cal.setTime(gregorian.getTime());
		return cal;
	}

	/**
	 *
	 * @param d1
	 *            : The First date to compare.
	 * @param d2
	 *            : The second date to compare.
	 * @return the number of days between the two dates.
	 */
	public static int daysBetween(Date d1, Date d2) {
		int milliseconds = 1000;
		int seconds = 60;
		int minutes = 60;
		int hours = 24;

		return (int) ((d2.getTime() - d1.getTime()) / (milliseconds * seconds * minutes * hours));

	}

	/**
	 * 
	 * @param date1
	 *            : The First date to compare.
	 * @param date2
	 *            : The Second date to compare.
	 * @return the number of months between two dates.
	 */
	public static int getMonthsDifference(Calendar date1, Calendar date2) {
		int m1 = date1.get(Calendar.YEAR) * 12 + date1.get(Calendar.MONTH);
		int m2 = date2.get(Calendar.YEAR) * 12 + date2.get(Calendar.MONTH);
		return m2 - m1 + 1;
	}

	/**
	 * 
	 * @return Todays Hijri date.
	 */
	public static Calendar getTodaysHigriDate() {
		UmmalquraCalendar cal = new UmmalquraCalendar();
		cal.get(Calendar.YEAR);
		cal.get(Calendar.MONTH);
		cal.get(Calendar.DAY_OF_MONTH);

		return cal;
	}

	/**
	 * 
	 * @param startCal
	 *            : The First Hijri date.
	 * @param endCal
	 *            : The Second Hijri date.
	 * @return the number of days between the two hijri dates.
	 */
	public static int getNumberOfDaysBetweenTwoHijriDates(Calendar startCal, Calendar endCal) {

		Calendar start = Calendar.getInstance();
		start.setTimeZone(startCal.getTimeZone());
		start.setTimeInMillis(startCal.getTimeInMillis());

		Calendar end = Calendar.getInstance();
		end.setTimeZone(endCal.getTimeZone());
		end.setTimeInMillis(endCal.getTimeInMillis());

		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);

		end.set(Calendar.HOUR_OF_DAY, 0);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);

		return (int) (TimeUnit.MILLISECONDS.toDays(end.getTimeInMillis() - start.getTimeInMillis()));
	}

	/**
	 * 
	 * @param gregorianCalendar
	 *            : The Gregorian calendar that needs to be converted.
	 * @return the converted Ummalqura calendar.
	 */
	public static Calendar convertFromGregorianCalendarToUmmalquraCalendar(Calendar gregorianCalendar) {
		Calendar cal = new UmmalquraCalendar();
		int year = gregorianCalendar.get(Calendar.YEAR);
		int month = gregorianCalendar.get(Calendar.MONTH);
		int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

}