package io.github.daschner.Xye.functions.math;

import javax.script.ScriptException;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.devs.Daschner;
/**
 * @author Mr. Daschner
 */
public class Basic 
{
	
	/**
	 * Uses the script engine to iterate through and solve problems.
	 * 
	 * @param problem - The problem for the script engine to complete.
	 * @return The numerical answer to the problem in a double.
	 * @throws ScriptException If the script cannot be completed.
	 * @throws ClassNotFoundException 
	 */
	
	public double evaluateString(String problem) throws ScriptException
	{
		
		return (Double) Daschner.scriptEngine.eval(problem);
		
	}
	/**
	 * 
	 * @param open The open value.
	 * @param high The high value.
	 * @param low The low value.
	 * @param close The close value.
	 * @param volume The volume amount. Has to be a long due to large volumes.
	 * @param adjClose The adjClose amount.
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
	
	public long openTotal(Stock stock)
	{
		long totalOpen = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalOpen = totalOpen + (long)stock.getDateTable().get(date).getOpen();
		}
		return totalOpen;
	}
	
	public long highTotal(Stock stock)
	{
		long totalHigh = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalHigh = totalHigh + (long)stock.getDateTable().get(date).getHigh();
		}
		return totalHigh;
	}
	
	public long lowTotal(Stock stock)
	{
		long totalLow = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalLow = totalLow + (long)stock.getDateTable().get(date).getLow();
		}
		return totalLow;
	}
	
	public long closeTotal(Stock stock)
	{
		long totalClose = 0L;
		for(Date date : stock.getDateTable().keySet())
		{
			totalClose = totalClose + (long)stock.getDateTable().get(date).getClose();
		}
		return totalClose;
	}
	
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
