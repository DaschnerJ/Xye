package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.devs.Daschner;

import javax.script.ScriptException;
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
	
	/**
	 * 
	 * @param open The open value.
	 * @param high The high value.
	 * @param low The low value.
	 * @param close The close value.
	 * @param volume The volume amount. Has to be a long due to large volumes.
	 * @param adjClose The adjClose amount.
	 */
	public double volumeMean(Stock stock)
	{
		long total = volumeTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public double openMean(Stock stock)
	{
		long total = openTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public double highMean(Stock stock)
	{
		long total = highTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public double lowMean(Stock stock)
	{
		long total = lowTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public double closeMean(Stock stock)
	{
		long total = closeTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public double adjCloseMean(Stock stock)
	{
		long total = adjCloseTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	public long volumeMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			long min = 0;
			long current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = (long)stock.getDateTable().get(date).getVolume();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0L;
	}
	
	public double openMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double min = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getOpen();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0;
	}
	
	public double closeMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double min = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getClose();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0;
	}
	
	public double highMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double min = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getHigh();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0;
	}
	
	public double lowMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double min = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getLow();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0;
	}
	
	public double adjCloseMin(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double min = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getAdjClose();
				if(min == 0)
					min = current;
				else if(min > current)
					min = current;
				else {}
			}
			return min;	
		}
		else
			return 0;
	}
	
	public long volumeMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			long max = 0;
			long current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = (long)stock.getDateTable().get(date).getVolume();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0L;
	}
	
	public double openMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double max = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getOpen();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0;
	}
	
	public double closeMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double max = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getClose();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0;
	}
	
	public double highMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double max = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getHigh();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0;
	}
	
	public double lowMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double max = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getLow();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0;
	}
	
	public double adjCloseMax(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			double max = 0;
			double current = 0;
			for(Date date : stock.getDateTable().keySet())
			{
				current = stock.getDateTable().get(date).getAdjClose();
				if(max < current)
					max = current;
				else {}
			}
			return max;	
		}
		else
			return 0;
	}

	

}
