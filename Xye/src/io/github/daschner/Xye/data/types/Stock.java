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
	
	public boolean addDateTrade(Date date, Trade trade)
	{
		addIndiceTrade(trade);
		dateTable.put(date, trade);
		return true;
	}
	
	private boolean addIndiceTrade(Trade trade)
	{
		indiceTable.put(getAvailableIndex(), trade);
		return true;
	}
	
	public boolean addIndiceTrade(Date date, Trade trade)
	{
		addDateTrade(date, trade);
		return true;
	}
	
	public Integer getAvailableIndex()
	{
		if(indiceTable != null)
			return indiceTable.size();
		else
			return 0;
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
	
	public Integer getTradeIndex(Trade trade)
	{
		for(Integer index : indiceTable.keySet())
		{
			if(indiceTable.get(index).equals(trade))
				return index;
		}
		return null;
	}
	
	public boolean removeTrade(Trade trade)
	{
		if(trade != null)
		{
			if(dateTable.containsValue(trade) && indiceTable.containsKey(trade))
			{
				Trade duplicate = getDuplicateTrade(trade);
				if(duplicate != null)
				{
					int index = getTradeIndex(trade);
					Date date = getTradeDate(trade);
					
					dateTable.remove(date);
					indiceTable.put(index, duplicate);
					
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
		else
			return false;
	}
	
	public boolean removeTrade(Date date)
	{
		removeTrade(dateTable.get(date));
		return true;
	}
	
	public boolean removeTrade(Integer index)
	{
		removeTrade(indiceTable.get(index));
		return true;
	}
	
	public Trade getDuplicateTrade(Trade trade)
	{
		int index = getTradeIndex(trade);
		Date date = getTradeDate(trade);
		
		if(date == null || indiceTable == null || dateTable == null)
		{
			//Do nothing since trade doesn't exist
			return null;
		}
		else if(index == 0 && date != null)
		{
			if(indiceTable.size() > 1)
			{
				preDate = true;
				return indiceTable.get(index++);
			}
			else
			{
				clearDateTable();
				clearIndiceTable();
				return null;
			}
		}
		else if(index == indiceTable.size()-1 && date != null)
		{
			return indiceTable.get(index--);
		}
		else
		{
			return indiceTable.get(index--);
		}
	}

	public boolean deleteTrade(Trade trade)
	{
		if(trade != null)
		{
			if(dateTable.containsKey(trade) && indiceTable.containsKey(trade))
			{
				int index = getTradeIndex(trade);
				Date date = getTradeDate(trade);
				
				dateTable.remove(date);
				indiceTable.remove(index);
				
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
	
	public boolean deleteTrade(Integer index)
	{
		deleteTrade(indiceTable.get(index));
		return true;
	}
	
	public boolean reformatTables()
	{
		if(indiceTable.isEmpty() || dateTable.isEmpty())
			return true;
		else
		{
			
			HashMap<Integer, Trade> newIndiceTable = new HashMap<Integer, Trade>();
			
			int size = indiceTable.size();
			
			int counter = 0;
			
			for(int i = 0; i < size; i++)
			{
				
				if(i + 1 < size)
				{
					
					if(indiceTable.get(i).equals(indiceTable.get(i+1)))
					{
						
						if(preDate)
						{
							
							newIndiceTable.put(counter, indiceTable.get(i+1));
							
							i++;
							
							counter++;
							
						}
						else
						{
							
							newIndiceTable.put(counter, indiceTable.get(i));
							
							i++;
							
							counter++;
							
						}
						
					}
					else
					{
						
						newIndiceTable.put(counter, indiceTable.get(i));
						
						counter++;
						
					}
					
				}
				
			}
			
			indiceTable = newIndiceTable;
			
			return true;
		}
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
