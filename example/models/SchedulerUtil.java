package models;

import java.util.Calendar;
import java.util.Date;


/**
 * Helper class used by the scheduler.
 */
public class SchedulerUtil 
{
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	/**
	 * Converts a string in a {@link Date}.
	 * 
	 * @param dateStr String in a date format (MM/DD/YYYY)
	 * @return Date converted using the provided string
	 */
	public static Date getDateFromString(String dateStr)
	{
		Calendar date = Calendar.getInstance();
		
		// mm/dd/yyyy
		// 0123456789  }-> index
		date.set(Calendar.YEAR, Integer.parseInt(dateStr.substring(6, 10)));
		date.set(Calendar.MONTH, Integer.parseInt(dateStr.substring(3, 5)));
		date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr.substring(0, 2)));
		   
		return date.getTime();
	}
}
