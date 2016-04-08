package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;

public class Minimum {

	public Minimum()
	{
		
	}
	
	/**
	 * Calculates the minimum of the data type of a stock.
	 * @param stock The stock to find the desired minimum of a data type.
	 * @param type The data type to calculate the minimum of.
	 * @return Returns the minimum of the selected data type.
	 */
	public long MinType(Stock stock, DataType type)
	{
		if(!stock.getDateTable().isEmpty())
		{
			long min = 0;
			long current = 0;
			int code = type.getDataCode();
			switch(code)
			{
			case 0:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getVolume();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			case 1:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getOpen();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			case 2:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getClose();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			case 3:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getHigh();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			case 4:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getLow();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			case 5:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getAdjClose();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			default:
				for(Date date : stock.getDateTable().keySet())
				{
					current = (long)stock.getDateTable().get(date).getVolume();
					if(min == 0)
						min = current;
					else if(min > current)
						min = current;
					else {}
				}
				break;
			}
			return min;	
		}
		else
			return 0L;
	}


}
