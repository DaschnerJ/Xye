package io.github.daschner.Xye.functions.math;

import java.util.ArrayList;
import java.util.Collections;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Median {
	
	public Median()
	{
		
	}

	/**
	 * Calculates the median Volume of a stock.
	 * @param stock The stock to find the desired median Volume.
	 * @return Returns the median Volume.
	 */
	public long volumeMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Long> dataSet = new ArrayList<Long>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getVolume());
			}
			Collections.sort(dataSet);
			long median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0L;
	}
	
	/**
	 * Calculates the median High of a stock.
	 * @param stock The stock to find the desired median High.
	 * @return Returns the median High.
	 */
	public double highMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Double> dataSet = new ArrayList<Double>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getHigh());
			}
			Collections.sort(dataSet);
			double median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0;
	}
	
	/**
	 * Calculates the median Low of a stock.
	 * @param stock The stock to find the desired median Low.
	 * @return Returns the median Low.
	 */
	public double lowMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Double> dataSet = new ArrayList<Double>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getLow());
			}
			Collections.sort(dataSet);
			double median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0;
	}
	
	/**
	 * Calculates the median Open of a stock.
	 * @param stock The stock to find the desired median Open.
	 * @return Returns the median Open.
	 */
	public double openMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Double> dataSet = new ArrayList<Double>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getOpen());
			}
			Collections.sort(dataSet);
			double median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0;
	}
	
	/**
	 * Calculates the median Close of a stock.
	 * @param stock The stock to find the desired median Close.
	 * @return Returns the median Close.
	 */
	public double closeMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Double> dataSet = new ArrayList<Double>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getClose());
			}
			Collections.sort(dataSet);
			double median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0;
	}
	
	/**
	 * Calculates the median Adjusted Close of a stock.
	 * @param stock The stock to find the desired median Adjusted Close.
	 * @return Returns the median Adjusted Close.
	 */
	public double adjCloseMedian(Stock stock)
	{
		if(!stock.getDateTable().isEmpty())
		{
			ArrayList<Double> dataSet = new ArrayList<Double>();
			for(Date date : stock.getDateTable().keySet())
			{
				dataSet.add(stock.getDateTable().get(date).getAdjClose());
			}
			Collections.sort(dataSet);
			double median;
			if(dataSet.size()%2 == 0)
			{
				median = (dataSet.get(dataSet.size()/2) + dataSet.get((dataSet.size()/2)+1))/2;
				return median;
			}
			else
				return dataSet.get(dataSet.size()/2);
		}
		else
			return 0;
	}

}
