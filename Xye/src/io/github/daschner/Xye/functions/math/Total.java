package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Total {
	
	public Total()
	{
		
	}
	
	/**
	 * Calculates the total Volume of a stock.
	 * @param stock The stock to find the desired total Volume.
	 * @return Returns the total Volume.
	 */
	public long volumeTotal(Stock stock)
	{
		long totalVolume = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalVolume = totalVolume + stock.getDateTable().get(date).getVolume();
		}
		return totalVolume;
	}
	
	/**
	 * Calculates the total Open of a stock.
	 * @param stock The stock to find the desired total Open.
	 * @return Returns the total Open.
	 */
	public long openTotal(Stock stock)
	{
		long totalOpen = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalOpen = totalOpen + (long)stock.getDateTable().get(date).getOpen();
		}
		return totalOpen;
	}
	
	/**
	 * Calculates the total High of a stock.
	 * @param stock The stock to find the desired total High.
	 * @return Returns the total High.
	 */
	public long highTotal(Stock stock)
	{
		long totalHigh = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalHigh = totalHigh + (long)stock.getDateTable().get(date).getHigh();
		}
		return totalHigh;
	}
	
	/**
	 * Calculates the total Low of a stock.
	 * @param stock The stock to find the desired total Low.
	 * @return Returns the total Low.
	 */
	public long lowTotal(Stock stock)
	{
		long totalLow = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalLow = totalLow + (long)stock.getDateTable().get(date).getLow();
		}
		return totalLow;
	}
	
	/**
	 * Calculates the total Closing of a stock.
	 * @param stock The stock to find the desired total Closing.
	 * @return Returns the total Closing.
	 */
	public long closeTotal(Stock stock)
	{
		long totalClose = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalClose = totalClose + (long)stock.getDateTable().get(date).getClose();
		}
		return totalClose;
	}
	
	/**
	 * Calculates the total Adjusted Close of a stock.
	 * @param stock The stock to find the desired total Adjusted Close.
	 * @return Returns the total Adjusted Close.
	 */
	public long adjCloseTotal(Stock stock)
	{
		long totalAdjClose = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalAdjClose = totalAdjClose + (long)stock.getDateTable().get(date).getAdjClose();
		}
		return totalAdjClose;
	}

}
