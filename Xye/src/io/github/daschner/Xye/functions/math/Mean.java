package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Stock;

public class Mean {
	
	public Mean(){
		
	}
	
	private Total t = new Total();
	
	/**
	 * Calculates the mean of the data type of a stock.
	 * @param stock The stock to find the desired mean Volume.
	 * @return Returns the mean Volume.
	 */
	public double MeanType(Stock stock, DataType type)
	{
		long total = t.TotalType(stock, type);
		int n = stock.getDateTable().size();
		
		double mean = total/n;
		
		return mean;	
	}

}
