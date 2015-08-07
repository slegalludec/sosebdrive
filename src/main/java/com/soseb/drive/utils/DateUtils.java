package com.soseb.drive.utils;

import java.util.Date;

public class DateUtils {

	/**
	 * Check if user right are already ok
	 * @param rightStartDate
	 * 		the right start date
	 * @param rightEndDate
	 * 		the right end date
	 * @return boolean if user own right or not
	 */
	public static boolean checkDate(final Date rightStartDate, final Date rightEndDate) {

		Date currentDate = new Date();

		return (currentDate.after(rightStartDate) && currentDate.before(rightEndDate)) ? true : false;

	}
	
}
