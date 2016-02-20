package io.github.daschner.Xye.data.url;

import io.github.daschner.Xye.data.types.Date;

/**
 * 
 * @author PoisonedPorkchop
 *
 */

public class UrlHandler {
	
	/**
	 * Gets a stock over a period of time.
	 * 
	 * @param stockName - Use the letters that represent this stock. (For example: Google uses GOOG)
	 * @param dateStart - The starting date to get information from. (Format: Month/Day/Year, Example: 01/1/2016)
	 * @param dateEnd - The ending date to get information from. (Format: Month/Day/Year, Example: 12/31/2016)
	 * @return URL for this stock at the specified dates and time.
	 */
	
	public String getStockUrlForDate(String stockName, Date dateStart, Date dateEnd) {
		
		String firstMonth = "" + dateStart.getMonth().ordinal();
		
		String secondMonth = "" + dateEnd.getMonth().ordinal();
		
		if(dateStart.getMonth().ordinal() < 10) {
			
			firstMonth = "0" + firstMonth;
			
		}
		
		if(dateEnd.getMonth().ordinal() < 10) {
			
			secondMonth = "0" + secondMonth;
			
		}
		
		return "http://real-chart.finance.yahoo.com/table.csv?s=%5E" + stockName + "&a=" + firstMonth + "&b=" + dateStart.getDay() + "&c=" + dateStart.getYear() + "&d=" + secondMonth + "&e=" + dateEnd.getDay() + "&f=" + dateEnd.getYear() + "&g=d&ignore=.csv";
		
	}
	
	/**
	 * Gets a stock for a single day.
	 * 
	 * @param stockName - Use the letters that represent this stock. (For example: Google uses GOOG)
	 * @param date - The starting date to get information from. (Format: Month/Day/Year, Example: 01/1/2016)
	 * @return URL for this stock at the specified date and time.
	 */
	
	public String getStockUrlForDate(String stockName, Date date) {
		
		String firstMonth = "" + date.getMonth().ordinal();
		
		if(date.getMonth().ordinal() < 10) {
			
			firstMonth = "0" + firstMonth;
			
		}
		
		return "http://real-chart.finance.yahoo.com/table.csv?s=%5E" + stockName + "&a=" + firstMonth + "&b=" + date.getDay() + "&c=" + date.getYear() + "&d=" + firstMonth + "&e=" + date.getDay() + "&f=" + date.getYear() + "&g=d&ignore=.csv";
		
	}
	
}
