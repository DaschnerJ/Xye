package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.devs.Daschner;

import java.util.ArrayList;
import java.util.Collections;

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
	
	/**
	 * Calculates the mean Volume of a stock.
	 * @param stock The stock to find the desired mean Volume.
	 * @return Returns the mean Volume.
	 */
	public double volumeMean(Stock stock)
	{
		long total = volumeTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	/**
	 * Calculates the mean Open of a stock.
	 * @param stock The stock to find the desired mean Open.
	 * @return Returns the mean Open.
	 */
	public double openMean(Stock stock)
	{
		long total = openTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	/**
	 * Calculates the mean High of a stock.
	 * @param stock The stock to find the desired mean High.
	 * @return Returns the mean High.
	 */
	public double highMean(Stock stock)
	{
		long total = highTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	/**
	 * Calculates the mean Low of a stock.
	 * @param stock The stock to find the desired mean Low.
	 * @return Returns the mean Low.
	 */
	public double lowMean(Stock stock)
	{
		long total = lowTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	/**
	 * Calculates the mean Close of a stock.
	 * @param stock The stock to find the desired Close High.
	 * @return Returns the mean Close.
	 */
	public double closeMean(Stock stock)
	{
		long total = closeTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}
	
	/**
	 * Calculates the mean Adjusted Close of a stock.
	 * @param stock The stock to find the desired mean Adjusted Close.
	 * @return Returns the mean Adjusted Close.
	 */
	public double adjCloseMean(Stock stock)
	{
		long total = adjCloseTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
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

	

}
