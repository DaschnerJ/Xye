package io.github.poisonedporkchop.Xye.data.files;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Month;
import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.data.types.Trade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Damien Claessen
 */
public class FileLoader {
	
	/**
	 * Parse a file for Trade data.
	 * 
	 * @param filePath - The folder of the file to load.
	 * @param fileName - The name of the file to load.
	 * @param stockID - The ID of the stock to associate with the Trades.
	 * @return A List of Trades from the specified file.
	 */
	
	public List<Trade> getTradesFromFile(String filePath, String fileName, String stockID) {
		
		List<Trade> trades = new ArrayList<Trade>();
		
		FileReader fileReader = null;
		
		FileHandler fileHandler = new FileHandler();
		
		fileHandler.createFolder(filePath);
		
		File file = new File("C:\\Xye\\" + filePath + "\\" + fileName);
		
		if (file.isFile()) {
			
			try {
				
				fileReader = new FileReader(file);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file read!");
				
				return null;
				
			}
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String currentLine;
			
			int letterIndexStart = 0;
			int letterIndexEnd = 1;
			
			try {
				
				while ((currentLine = reader.readLine()) != null) {
					
					List<String> data = new ArrayList<String>();
					
					while(letterIndexEnd < currentLine.length()) {
					
						while (letterIndexEnd <= currentLine.length() && !currentLine.substring(letterIndexStart, letterIndexEnd).contains(",")) {

							letterIndexEnd++;

						}
						
						String retrieved = currentLine.substring(letterIndexStart, letterIndexEnd - 1);
						
						letterIndexStart = letterIndexEnd;
						
						letterIndexEnd = letterIndexEnd + 1;
						
						data.add(retrieved);
					
					}
					
					if(data.size() == 7) {
						
						Trade trade = new Trade(stockID, new Date(Integer.parseInt(data.get(0).substring(8, 10)), Month.values()[Integer.parseInt(data.get(0).substring(5, 7)) - 1], Integer.parseInt(data.get(0).substring(0, 4))), Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)), Double.parseDouble(data.get(3)), Double.parseDouble(data.get(4)), Long.parseLong(data.get(5)), Double.parseDouble(data.get(6)));
						
						trades.add(trade);
						
						data.clear();
						
						letterIndexStart = 0;
						letterIndexEnd = 1;
						
					}
					else
					{
						
						data.clear();
						
						letterIndexStart = 0;
						letterIndexEnd = 1;
						
						System.out.println("WARNING: Could not load a line from file '" + "C:\\Xye\\" + filePath + "\\" + fileName + "' as it was not in correct format!");
						
					}
					
				}
				
				reader.close();
				
				return trades;
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file read!");
				
				return null;
				
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Creates a Stock from a file.
	 * 
	 * @param filePath - Path of the file to get the Stock from.
	 * @param fileName - Name of the file to get the Stock from.
	 * @param stockID - Identifier of the stock.
	 * @return The Stock from the file.
	 */
	
	public Stock getStockFromFile(String filePath, String fileName, String stockID) {
		
		Stock stock = new Stock(stockID);
		
		List<Trade> trades = this.getTradesFromFile(filePath, fileName, stockID);
		
		stock.putListOfTrades(trades);
		
		return stock;
		
	}
	
}
