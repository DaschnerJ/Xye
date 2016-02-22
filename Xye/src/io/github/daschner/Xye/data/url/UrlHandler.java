package io.github.daschner.Xye.data.url;

import io.github.daschner.Xye.data.types.Date;
import io.github.poisonedporkchop.Xye.data.files.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author Damien Claessen
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
	
	public URL getStockUrlForDate(String stockName, Date dateStart, Date dateEnd) {
		
		String firstMonth = "" + dateStart.getMonth().ordinal();
		
		String secondMonth = "" + dateEnd.getMonth().ordinal();
		
		if(dateStart.getMonth().ordinal() < 10) {
			
			firstMonth = "0" + firstMonth;
			
		}
		
		if(dateEnd.getMonth().ordinal() < 10) {
			
			secondMonth = "0" + secondMonth;
			
		}
		
		try {
			
			return new URL("http://real-chart.finance.yahoo.com/table.csv?s=" + stockName + "&a=" + firstMonth + "&b=" + dateStart.getDay() + "&c=" + dateStart.getYear() + "&d=" + secondMonth + "&e=" + dateEnd.getDay() + "&f=" + dateEnd.getYear() + "&g=d&ignore=.csv");
			
		} catch (MalformedURLException e) {
			
			return null;
			
		}
		
	}
	
	/**
	 * Gets a stock for a single day.
	 * 
	 * @param stockName - Use the letters that represent this stock. (For example: Google uses GOOG)
	 * @param date - The starting date to get information from. (Format: Month/Day/Year, Example: 01/1/2016)
	 * @return URL for this stock at the specified date and time.
	 */
	
	public URL getStockUrlForDate(String stockName, Date date) {
		
		String firstMonth = "" + date.getMonth().ordinal();
		
		if(date.getMonth().ordinal() < 10) {
			
			firstMonth = "0" + firstMonth;
			
		}
		
		try {
			
			return new URL("http://real-chart.finance.yahoo.com/table.csv?s=" + stockName + "&a=" + firstMonth + "&b=" + date.getDay() + "&c=" + date.getYear() + "&d=" + firstMonth + "&e=" + date.getDay() + "&f=" + date.getYear() + "&g=d&ignore=.csv");
			
		} catch (MalformedURLException e) {
			
			return null;
			
		}
		
	}
	
	/**
	 * Use this method to validate if a URL is online or working.
	 * 
	 * @param url - The URL to validate
	 * @return True if the URL is valid, false otherwise.
	 */
	
	public boolean validateURL(URL url) {
		
		HttpURLConnection website = null;
		
		try {
			
			website = (HttpURLConnection) url.openConnection();
			
			website.setConnectTimeout(10000);
			
			website.setRequestMethod("GET");
			
			website.connect();
			
			if(website.getResponseCode() == HttpURLConnection.HTTP_OK) {
				
				return true;
				
			}
			else if(website.getResponseCode() == HttpURLConnection.HTTP_OK) {
				
				return false;
				
			}
			else {
				
				return false;
				
			}
			
		} catch (Exception e) {
			
			return false;
			
		} finally {
			
			if (website != null) {
				
				website.disconnect();
				
			}

		}
		
	}
	
	/**
	 * Downloads a file from a URL.
	 * 
	 * @param url - The URL to download from.
	 * @param path - Path in Xye folder to put the new file.
	 * @param fileName - Name of new file.
	 * @return Path to the newly downloaded file.
	 */
	
	public String downloadFileFromURL(URL url, String path, String fileName) {
		
		ReadableByteChannel rbc = null;
		
		try {
			
			rbc = Channels.newChannel(url.openStream());
			
		} catch (IOException e1) {
			
			System.out.println("ERROR: Byte Channel could not be initialized!");
			
		}
		
		FileOutputStream fos = null;
		
		try {
			
			new FileHandler().createFolder(path);
			
			fos = new FileOutputStream("C:\\Xye\\" + path + "\\" + fileName);
			
			try {
				
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				
				try {
					
					fos.close();
					
					File file = new File("C:\\Xye\\" + path + "\\" + fileName);
					
					if(file.length() == 0) {
						
						file.delete();
						
					}
					
				} catch (IOException e) {
					
					System.out.println("ERROR: FileStream could not be closed!");
					
				}
				
			} catch (IOException e) {
				
				System.out.println("ERROR: Transfer of bytes failed!");
				
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("ERROR: FileStream could not be created!");
			
		}
		
		return (path + "\\" + fileName);
		
	}
	
	/**
	 * Automatically check for, get, and process a stock.
	 * 
	 * @param stockName - The stock identifier for this stock you are trying.
	 * @param date1 - The date to start getting history from.
	 * @param date2 - The date to end getting history from.
	 */
	
	public void getAndProcessFromUrl(String stockName, Date date1, Date date2) {
		
		FileHandler handler = new FileHandler();
		
		URL url = getStockUrlForDate(stockName, date1, date2);
		
		if(validateURL(url)) {
			
			downloadFileFromURL(url, "Downloads\\Stocks\\" + stockName, stockName + " " + (date1.getMonth().ordinal() + 1) + "-" + date1.getDay() + "-" + date1.getYear() + ".csv");
			
		}
		else
		{
			
			System.out.println("WARNING: Could not download '" + (date1.getMonth().ordinal() + 1) + "-" + date1.getDay() + "-" + date1.getYear() + "' as it was not available.");
			
		}
		
		handler.processTrade("Downloads\\Stocks\\" + stockName, "Data\\Stocks\\" + stockName, stockName + " " + (date1.getMonth().ordinal() + 1) + "-" + date1.getDay() + "-" + date1.getYear() + ".csv") ;
		
	}
	
	/**
	 * Automatically check for, get, and process a stock.
	 * 
	 * @param stockName - The stock identifier for this stock you are trying.
	 * @param date - The date for which to get data on.
	 */
	
	public void getAndProcessFromUrl(String stockName, Date date) {
		
		FileHandler handler = new FileHandler();
		
		URL url = getStockUrlForDate(stockName, date);
		
		if(validateURL(url)) {
			
			downloadFileFromURL(url, "Downloads\\Stocks\\" + stockName, stockName + " " + (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + ".csv");
			
		}
		else
		{
			
			System.out.println("WARNING: Could not download '" + (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + "' as it was not available.");
			
		}
		
		handler.processTrade("Downloads\\Stocks\\" + stockName, "Data\\Stocks\\" + stockName, stockName + " " + (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + ".csv") ;
		
	}
	
	/**
	 * Automatically check for, get, and process all history of a stock.
	 * 
	 * @param stockName - The stock identifier for this stock you are trying.
	 */
	
	public void getAndProcessFromUrl(String stockName) {
		
		FileHandler fileHandler = new FileHandler();
		
		Date date = Date.getCurrentDate();
		
		date.setDay(32);
		
		URL url = getStockUrlForDate(stockName, date);
		
		if(validateURL(url)) {
			
			downloadFileFromURL(url, "Downloads\\Stocks\\" + stockName, stockName + " " + "All" + ".csv");
			
		}
		else
		{
			
			System.out.println("WARNING: Could not download '" + (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + "' as it was not available.");
			
		}
		
		fileHandler.processTrade("Downloads\\Stocks\\" + stockName, "Data\\Stocks\\" + stockName, stockName + " " + "All" + ".csv") ;
		
	}
	
}
