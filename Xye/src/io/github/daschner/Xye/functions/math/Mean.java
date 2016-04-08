package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Stock;

public class Mean {
	
	public Mean(){
		
	}
	
	private Total t = new Total();
	
	/**
	 * Calculates the mean Volume of a stock.
	 * @param stock The stock to find the desired mean Volume.
	 * @return Returns the mean Volume.
	 */
	public double volumeMean(Stock stock)
	{
		long total = t.volumeTotal(stock);
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
		long total = t.openTotal(stock);
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
		long total = t.highTotal(stock);
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
		long total = t.lowTotal(stock);
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
		long total = t.closeTotal(stock);
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
		long total = t.adjCloseTotal(stock);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}

}
