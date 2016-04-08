package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Minimum {

	public Minimum()
	{
		
	}
	
	/**
	 * Calculates the minimum Volume of a stock.
	 * @param stock The stock to find the desired minimum Volume.
	 * @return Returns the minimum Volume.
	 */
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
	
	/**
	 * Calculates the minimum Open of a stock.
	 * @param stock The stock to find the desired minimum Open.
	 * @return Returns the minimum Open.
	 */
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
	
	/**
	 * Calculates the minimum Close of a stock.
	 * @param stock The stock to find the desired minimum Close.
	 * @return Returns the minimum Close.
	 */
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
	
	/**
	 * Calculates the minimum High of a stock.
	 * @param stock The stock to find the desired minimum High.
	 * @return Returns the minimum High.
	 */
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
	
	/**
	 * Calculates the minimum Low of a stock.
	 * @param stock The stock to find the desired minimum Low.
	 * @return Returns the minimum Low.
	 */
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
	
	/**
	 * Calculates the minimum Adjusted Close of a stock.
	 * @param stock The stock to find the desired minimum Adjajcent Close.
	 * @return Returns the minimum Adjusted Close.
	 */
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

}
