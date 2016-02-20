package io.github.daschner.Xye.data.types;
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
	

}
