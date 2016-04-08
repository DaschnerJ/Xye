package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Maximum {
	
	public Maximum()
	{
		
	}
	
	/**
	 * Calculates the maximum Volume of a stock.
	 * @param stock The stock to find the desired maximum Volume.
	 * @return Returns the maximum Volume.
	 */
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
	
	/**
	 * Calculates the maximum Open of a stock.
	 * @param stock The stock to find the desired maximum Open.
	 * @return Returns the maximum Open.
	 */
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
	
	/**
	 * Calculates the maximum Close of a stock.
	 * @param stock The stock to find the desired maximum Close.
	 * @return Returns the maximum Close.
	 */
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
	
	/**
	 * Calculates the maximum High of a stock.
	 * @param stock The stock to find the desired maximum High.
	 * @return Returns the maximum High.
	 */
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
	
	/**
	 * Calculates the maximum Low of a stock.
	 * @param stock The stock to find the desired maximum Low.
	 * @return Returns the maximum Low.
	 */
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
	
	/**
	 * Calculates the maximum Adjusted Close of a stock.
	 * @param stock The stock to find the desired maximum Adjusted Close.
	 * @return Returns the maximum Adjusted Close.
	 */
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
