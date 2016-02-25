package io.github.daschner.Xye.data.types;
/**
 * @author Mr. Daschner
 */
public class Trade 
{
	/**
	 * Stock key, the three-four digit identifier.
	 */
	private String stockKey;
	/**
	 * Date of the trade.
	 */
	private Date date;
	/**
	 * The values for the open, high, low, close, and adjClose.
	 */
	private double open, high, low, close, adjClose;
	/**
	 * The volume of the stock. This has to be a long due to pure volume size.
	 */
	private long volume;

	/**
	 * Creates the data type.
	 * @param stockKey The three-four digit identifier.
	 * @param date The date of trade.
	 * @param open The open value.
	 * @param high The high value.
	 * @param low The low value.
	 * @param close The close value.
	 * @param volume The volume amount. Has to be a long due to large volumes.
	 * @param adjClose The adjClose amount.
	 */
	public Trade(String stockKey, Date date, double open, double high, double low, double close, long volume, double adjClose)
	{
		this.stockKey = stockKey;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjClose = adjClose;
	}
	/**
	 * Retrieves the stock key identifier.
	 * @return The stock key identifier.
	 */
	public String getStock()
	{
		return stockKey;
	}
	/**
	 * Retrieves the date of the trade.
	 * @return The date.
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * Retrieves the open value.
	 * @return The open value.
	 */
	public double getOpen()
	{
		return open;
	}
	/**
	 * Retrieves the high value.
	 * @return The high value.
	 */
	public double getHigh()
	{
		return high;
	}
	/**
	 * Returns the low value.
	 * @return The low value.
	 */
	public double getLow()
	{
		return low;
	}
	/**
	 * Returns the close value.
	 * @return The close value.
	 */
	public double getClose()
	{
		return close;
	}
	/**
	 * Returns the volume value.
	 * @return The volume value.
	 */
	public long getVolume()
	{
		return volume;
	}
	/**
	 * Returns the adjClose value.
	 * @return The adjClose value.
	 */
	public double getAdjClose()
	{
		return adjClose;
	}
	/**
	 * Sets the new stock identifier key.
	 * @param stockKey The stock identifier key to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setStockKey(String stockKey)
	{
		this.stockKey = stockKey;
		return true;
	}
	/**
	 * Sets the new date of the trade.
	 * @param date The date of the trade to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setDate(Date date)
	{
		this.date = date;
		return true;
	}
	/**
	 * Sets the new open value.
	 * @param open The open value to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setOpen(double open)
	{
		this.open = open;
		return true;
	}
	/**
	 * Sets the new close value.
	 * @param close The close value to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setClose(double close)
	{
		this.close = close;
		return true;
	}
	/**
	 * Sets the new high value.
	 * @param high The high value to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setHigh(double high)
	{
		this.high = high;
		return true;
	}
	/**
	 * Sets the new low value.
	 * @param low The low value to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setLow(double low)
	{
		this.low = low;
		return true;
	}
	/**
	 * Sets the new adjClose value.
	 * @param adjClose The adjClose to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setAdjClose(double adjClose)
	{
		this.adjClose = adjClose;
		return true;
	}
	/**
	 * Sets the new volume value. Volume has to be a long value due to volume being a large number.
	 * @param volume The volume to be set.
	 * @return Returns true if the value was successfully set.
	 */
	public boolean setVolume(long volume)
	{
		this.volume = volume;
		return true;
	}
	
	
	
}
