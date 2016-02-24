package io.github.daschner.Xye.data.types;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Mr. Daschner
 */
public class Date 
{
	/**
	 * The values for day and year.
	 */
	
	private int day, year;
	
	/**
	 * The enum for month.
	 */
	
	private Month month;
	
	/**
	 * Allows for the creation of dates with efficient access.
	 * @param day The integer value of the date's day.
	 * @param month The enum value of the date's month.
	 * @param year The integer value of the date's year.
	 */
	
	public Date(int day, Month month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Retrieves the day value.
	 * @return Returns the day.
	 */
	
	public int getDay()
	{
		return day;
	}
	
	/**
	 * Retrieves the month enum.
	 * @return Returns the month.
	 */
	
	public Month getMonth()
	{
		return month;
	}
	
	/**
	 * Retrieves the year value.
	 * @return Returns the year.
	 */
	
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Sets the new day value.
	 * @param day The new day integer.
	 * @return Returns true if the operation was sucessfully completed.
	 */
	
	public boolean setDay(int day)
	{
		this.day = day;
		return true;
	}
	
	/**
	 * Sets the new month enum.
	 * @param month The new month enum.
	 * @return Returns true if the operation was sucessfully completed.
	 */
	
	public boolean setMonth(Month month)
	{
		this.month = month;
		return true;
	}
	
	/**
	 * Sets the new year value.
	 * @param year The new year integer.
	 * @return Returns true if the operation was sucessfully completed.
	 */
	
	public boolean setYear(int year)
	{
		this.year = year;
		return true;
	}
	
	/**
	 * Gets the current date.
	 * 
	 * @return The date.
	 */
	
	public static Date getCurrentDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar cal = Calendar.getInstance();
		
		String date = dateFormat.format(cal.getTime());
		
		return new Date(Integer.parseInt(date.substring(0, 2)), Month.values()[Integer.parseInt(date.substring(3, 5)) - 1], Integer.parseInt(date.substring(6, 10)));
		
	}
	
	/**
	 * Gets the current day of the year.
	 * 
	 * @return The day it is today.
	 */
	
	public static int getCurrentDay() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd");
		
		Calendar cal = Calendar.getInstance();
		
		String date = dateFormat.format(cal.getTime());
		
		return Integer.parseInt(date);
		
	}
	
	/**
	 * Gets the current Month of the year.
	 * 
	 * @return The month it is now.
	 */
	
	public static Month getCurrentMonth() {
		
		DateFormat dateFormat = new SimpleDateFormat("MM");
		
		Calendar cal = Calendar.getInstance();
		
		String date = dateFormat.format(cal.getTime());
		
		return Month.values()[Integer.parseInt(date) - 1];
		
	}
	
	/**
	 * Gets the current year.
	 * 
	 * @return The year it is now.
	 */
	
	public static int getCurrentYear() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		
		Calendar cal = Calendar.getInstance();
		
		String date = dateFormat.format(cal.getTime());
		
		return Integer.parseInt(date);
		
	}
	
	/**
	 * Returns a String of the date.
	 * 
	 * @return A String of the date in the format:
	 * "year-month-day"
	 */
	
	public String toString() {
		
		String year,month,day = null;
		
		year = this.year + "";
		
		if(this.month.ordinal() + 1 < 10) {
			
			month = 0 + "" + this.month.ordinal() + 1;
			
		}
		else
		{
			
			month = "" + this.month.ordinal() + 1;
			
		}
		
		if(this.day < 10) {
			
			day = 0 + "" + this.day;
			
		}
		else
		{
			
			month = "" + this.day;
			
		}
		
		String date = year + "-" + month + "-" + day;
		
		return date;
		
	}

}
