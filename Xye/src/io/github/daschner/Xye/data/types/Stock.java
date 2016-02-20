package io.github.daschner.Xye.data.types;

import java.util.HashMap;
/**
 * @author Mr. Daschner
 */
public class Stock 
{
	private String stockKey;
	
	private HashMap<Date, Trade> dateTable = new HashMap<Date, Trade>();
	private HashMap<Integer, Trade> indiceTable = new HashMap<Integer, Trade>();
	
	public Stock(String stockKey)
	{
		this.stockKey = stockKey;
	}
	
	public String getStockKey()
	{
		return stockKey;
	}
	
	public boolean setStockKey(String stockKey)
	{
		this.stockKey = stockKey;
		return true;
	}
	
	public boolean checkTrade(Date date)
	{
		if(dateTable.containsKey(date))
			return true;
		else
			return false;
	}
	
	public boolean checkTrade(int index)
	{
		if(indiceTable.containsKey(index))
			return true;
		else
			return false;
	}
	
	public Trade getTrade(Date date)
	{
		if(checkTrade(date))
			return dateTable.get(date);
		else
			return null;
	}
	
	public Trade getTrade(int index)
	{
		if(checkTrade(index))
			return indiceTable.get(index);
		else 
			return null;
	}
	
	public boolean clearDateTable()
	{
		dateTable.clear();
		return true;
	}
	
	public boolean clearIndiceTable()
	{
		indiceTable.clear();
		return true;
	}
	
	public HashMap<Date, Trade> getDateTable()
	{
		return dateTable;
	}
	
	public HashMap<Integer, Trade> getIndiceTable()
	{
		return indiceTable;
	}
	
	public boolean setDateTable(HashMap<Date, Trade> dateTable)
	{
		this.dateTable = dateTable;
		return true;
	}
	
	public boolean setIndiceTable(HashMap<Integer, Trade> indiceTable)
	{
		this.indiceTable = indiceTable;
		return true;
	}
	
	

}
