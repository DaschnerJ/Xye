package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Total {
	
	public Total()
	{
		
	}
	
	/**
	 * Calculates the total data type of a stock.
	 * @param stock The stock to find the desired total data type.
	 * @param type The data type to find the total of.
	 * @return Returns the total of data type of a stock.
	 */
	public long TotalType(Stock stock, DataType type)
	{
		int code = type.getDataCode();
		long total = 0L;
		switch(code)
		{
		case 0:
			for(Date date : stock.getDateTable().keySet())
			{
				total = total + stock.getDateTable().get(date).getVolume();
			}
			break;
		case 1:
			for(Date date : stock.getDateTable().keySet())
			{
				total = (long) (total + stock.getDateTable().get(date).getOpen());
			}
			break;
		case 2:
			for(Date date : stock.getDateTable().keySet())
			{
				total = (long) (total + stock.getDateTable().get(date).getClose());
			}
			break;
		case 3:
			for(Date date : stock.getDateTable().keySet())
			{
				total = (long) (total + stock.getDateTable().get(date).getHigh());
			}
			break;
		case 4:
			for(Date date : stock.getDateTable().keySet())
			{
				total = (long) (total + stock.getDateTable().get(date).getLow());
			}
			break;
		case 5:
			for(Date date : stock.getDateTable().keySet())
			{
				total = (long) (total + stock.getDateTable().get(date).getAdjClose());
			}
			break;
		default:
			for(Date date : stock.getDateTable().keySet())
			{
				total = total + stock.getDateTable().get(date).getVolume();
			}
			break;
		}
		return total;
	}

}
