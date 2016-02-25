package io.github.daschner.Xye.data.types;

import io.github.poisonedporkchop.Xye.data.functions.DataManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
/**
 * @author Mr. Daschner
 */
public class Stock 
{
	private String stockKey;
	
	private boolean preDate = false;
	
	private HashMap<Date, Trade> dateTable = new HashMap<Date, Trade>();
	
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
	
	
	public Trade getTrade(Date date)
	{
		if(checkTrade(date))
			return dateTable.get(date);
		else
			return null;
	}

	public boolean clearDateTable()
	{
		dateTable.clear();
		return true;
	}
	
	public HashMap<Date, Trade> getDateTable()
	{
		return dateTable;
	}
	
	public boolean setDateTable(HashMap<Date, Trade> dateTable)
	{
		this.dateTable = dateTable;
		return true;
	}
	
	public boolean addDateTrade(Date date, Trade trade)
	{
		dateTable.put(date, trade);
		return true;
	}
	
	public boolean addIndiceTrade(Date date, Trade trade)
	{
		addDateTrade(date, trade);
		return true;
	}
	
	public Date getTradeDate(Trade trade)
	{
		for(Date date : dateTable.keySet())
		{
			if(dateTable.get(date).equals(trade))
				return date;
		}
		return null;
	}
	
	public boolean removeTrade(Trade trade)
	{
		if(trade != null)
		{
			if(dateTable.containsValue(trade))
			{
					Date date = getTradeDate(trade);
					
					dateTable.remove(date);					
					return true;
			}
			else
				return false;
			}
		else
		{
			return false;
		}

	}
	
	public boolean removeTrade(Date date)
	{
		removeTrade(dateTable.get(date));
		return true;
	}

	public boolean deleteTrade(Trade trade)
	{
		if(trade != null)
		{
			if(dateTable.containsKey(trade))
			{
				Date date = getTradeDate(trade);
				
				dateTable.remove(date);
				
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean deleteTrade(Date date)
	{
		deleteTrade(dateTable.get(date));
		return true;
	}
	
	public List<Trade> getListOfTrades() {
		
		List<Trade> trades = new ArrayList<>();
		
		DataManager dataManager = new DataManager();
		
		for(Entry<Date, Trade> entry : this.dateTable.entrySet()) {
			
			trades.add(entry.getValue());
			
		}
		
		return dataManager.sortTradesByDate(trades);
		
	}
	
	public void putListOfTrades(List<Trade> trades) {
		
		for(Trade trade : trades) {
			
			this.addDateTrade(trade.getDate(), trade);
			
		}
		
	}
	
	
}
