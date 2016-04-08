package io.github.daschner.Xye.functions.math;

import java.util.ArrayList;
import java.util.Collections;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class MovingAverage {
	
	public MovingAverage()
	{
		
	}
	
	/**
	 * Calculates the Moving Average of Adjusted Closing over a period of time.
	 * @param stock The stock to find the desired Moving Average of Adjusted Close.
	 * @param days The period of days to take the average over.
	 * @return Returns the mean over the period of days for Ajusted Closing.
	 */
	public double adjCloseMovingAverage(Stock stock, Integer days)
	{
		
		if(!stock.getDateTable().isEmpty())
		{
			
			ArrayList<Double> dataSet = new ArrayList<Double>();
			
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getAdjClose());
			}
			
			Collections.sort(dataSet);
			
			int numberOfEntries = dataSet.size();
			
			if(numberOfEntries >= days)
			{
				double totalOfEntries = 0;
				
				for(int i = 0; i < numberOfEntries; i++)
				{
					totalOfEntries = totalOfEntries + dataSet.get(numberOfEntries-1-i);
				}

				return totalOfEntries/days;
			}
			else
				return 0;		
		}
		else
			return 0;
	}
	
	/**
	 * Calculates the Moving Average of Adjusted Closing over a period of time.
	 * @param stock The stock to find the desired Moving Average of Adjusted Close.
	 * @param days The period of days to take the average over.
	 * @param Previous Offset in days to calculate the Moving Average of.
	 * @return Returns the mean over the period of days for Ajusted Closing.
	 */
	public double adjCloseMovingAverageN(Stock stock, Integer days, Integer Previous)
	{
		
		if(!stock.getDateTable().isEmpty())
		{
			
			ArrayList<Double> dataSet = new ArrayList<Double>();
			
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getAdjClose());
			}
			
			Collections.sort(dataSet);
			
			int numberOfEntries = dataSet.size();
			
			if(numberOfEntries >= days+Previous)
			{
				double totalOfEntries = 0;
				
				for(int i = 0; i < numberOfEntries; i++)
				{
					totalOfEntries = totalOfEntries + dataSet.get(numberOfEntries-1-i-Previous);
				}

				return totalOfEntries/days;
			}
			else
				return 0;		
		}
		else
			return 0;
	}

}
