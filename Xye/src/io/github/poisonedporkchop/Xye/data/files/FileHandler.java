package io.github.poisonedporkchop.Xye.data.files;

import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.data.types.Trade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Damien Claessen
 */

public class FileHandler {
	
	/**
	 * Processes a folder of downloaded stocks and removes unnecessary data from it.
	 * 
	 * @param path - The folder full of stocks to convert.
	 * @param targetPath - The folder to put the converted stocks in.
	 * @return Whether or not the conversion was successful.
	 */
	
	//BROKEN
	
	public boolean processTrade(String path, String targetPath) {

		FileReader fileReader = null;

		FileWriter fileWriter = null;

		File[] children;

		this.createFolder(path);

		File f = new File("C:\\Xye\\" + path);

		if (f.isDirectory()) {

			children = f.listFiles();

			if (children == null) {

				return false;

			}

		} else {

			System.out.println("ERROR: Invalid path at '" + path
					+ "' was found!");

			return false;

		}

		for (int x = 0; x < children.length; x++) {

			if (children[x].isFile()) {

				this.createFolder(targetPath);

				File newFile = new File("C:\\Xye\\" + targetPath + "\\" + children[x].getName());

				try {

					fileReader = new FileReader(children[x]);

					fileWriter = new FileWriter(newFile);

				} catch (IOException e1) {

					e1.printStackTrace();

					System.out.println("ERROR: Problem has occurred!");

				}

				BufferedReader reader = new BufferedReader(fileReader);

				BufferedWriter writer = new BufferedWriter(fileWriter);

				String currentLine;

				try {

					while ((currentLine = reader.readLine()) != null) {

						String trimmedLine = currentLine.trim();

						if (!trimmedLine.startsWith("Date,Open,High,Low,Close")) {
							
							writer.write(currentLine);

							reader.mark(500);

							currentLine = reader.readLine();

							if (currentLine != null) {

								writer.newLine();

							}

							reader.reset();
						
						}

					}

					writer.close();

					reader.close();
					
					if(newFile.length() == 0) {
						
						newFile.delete();
						
					}

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

		return true;

	}
	
	/**
	 * Processes a file of downloaded stocks and removes unnecessary data from it.
	 * 
	 * @param path - The folder where the file of stocks to convert is in.
	 * @param targetPath - The folder to put the converted stocks in.
	 * @param fileName - Name of the file to convert.
	 * @return Whether or not the conversion was successful.
	 */
	
	public boolean processTrade(String path, String targetPath, String fileName) {
		
		FileReader fileReader = null;
		
		FileWriter fileWriter = null;
		
		this.createFolder(path);
		
		File file = new File("C:\\Xye\\" + path + "\\" + fileName + ".csv");
		
		if (file.isFile()) {
			
			this.createFolder(targetPath);
			
			File newFile = new File("C:\\Xye\\" + targetPath + "\\" + fileName + ".stock");
			
			try {
				
				fileReader = new FileReader(file);
				
				fileWriter = new FileWriter(newFile);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file edit!");
				
				return false;
				
			}
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String currentLine;
			
			try {
				
				while ((currentLine = reader.readLine()) != null) {
					
					String trimmedLine = currentLine.trim();
					
					if (!trimmedLine.startsWith("Date,Open,High,Low,Close")) {
						
						writer.write(currentLine);

						reader.mark(500);

						currentLine = reader.readLine();

						if (currentLine != null) {

							writer.newLine();

						}

						reader.reset();
					
					}
					
				}
				
				writer.close();
				
				reader.close();
				
				if (newFile.length() == 0) {
					
					newFile.delete();
					
				}
				
				return true;
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file edit!");
				
				return false;
				
			}
			
		}
		
		System.out.println("ERROR: Could not process nonexistant file!");
		
		return false;
		
	}

	/**
	 * Creates a folder at the specified path.
	 * 
	 * @param path - The path at which to create the folder.
	 * @return True if folder was created or exists, false otherwise.
	 */

	public boolean createFolder(String path) {
	
		File f = new File("C:\\Xye\\" + path);
		
		try {
			
			f.mkdirs();
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println("ERROR: Folder could not be created!");
			
			return false;
			
		}
		
	}
	
	/**
	 * Takes a stock and converts it into a file
	 * 
	 * @param stock
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	
	public boolean createFileFromStock(Stock stock, String filePath, String fileName) {
		
		this.createFolder(filePath);
		
		File file = new File("C:\\Xye\\" + filePath + "\\" + fileName);
		
		if(!file.isFile()) {
			
			try {
				
				file.createNewFile();
				
			} catch (IOException e2) {
				
				System.out.println("ERROR: File could not be created.");
				
				return false;
				
			}
			
		}
		
		List<Trade> trades = stock.getListOfTrades();
			
			FileWriter fileWriter = null;
				
				try {
					
					fileWriter = new FileWriter(file);
					
				} catch (IOException e1) {
					
					System.out.println("ERROR: A problem with the file write has occured!");
					
					return false;
					
				}
				
				BufferedWriter writer = new BufferedWriter(fileWriter);
				
				for(int i = 0; i < trades.size(); i++) {
					
					if(i != 0) {
						
						try {
							
							writer.newLine();
							
						} catch (IOException e) {
							
							System.out.println("ERROR: A problem with file write has occured!");
							
						}
						
					}
					
					Trade trade = trades.get(i);
					
					try {
						
						writer.write(trade.getDate().getYear() + "-");
						
						if(trade.getDate().getMonth().ordinal()+1 < 10) {
							
							writer.write(0 + "" + (trade.getDate().getMonth().ordinal() + 1) + "-");
							
						}
						else
						{
							
							writer.write((trade.getDate().getMonth().ordinal() + 1) + "-");
							
						}
						
						if(trade.getDate().getDay() < 10) {
							
							writer.write(0 + "" + trade.getDate().getDay() + ",");
							
						}
						else
						{
							
							writer.write(trade.getDate().getDay() + ",");
							
						}
						
						writer.write(trade.getOpen() + ",");
						
						writer.write(trade.getHigh() + ",");
						
						writer.write(trade.getLow() + ",");
						
						writer.write(trade.getClose() + ",");
						
						writer.write(trade.getVolume() + ",");
						
						writer.write(trade.getAdjClose() + "");
						
					} catch (IOException e) {
						
						System.out.println("ERROR: A problem with file write has occured!");
						
					}
					
				}
				
				try {
					
					writer.close();
					
				} catch (IOException e) {
					
					System.out.println("ERROR: A problem with file write has occured!");
					
					return false;
					
				}
				
				return true;
		
	}
	
}
