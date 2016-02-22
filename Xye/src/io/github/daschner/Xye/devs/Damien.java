package io.github.daschner.Xye.devs;

import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.data.url.UrlHandler;
import io.github.poisonedporkchop.Xye.data.files.FileHandler;
import io.github.poisonedporkchop.Xye.data.files.FileLoader;

public class Damien 
{
	
	public static int x;
	
	//Libraries and APIs
	public static void preInitialization()
	{
		
		System.out.println("Starting Damien's PreInitialization phase.");
		
		System.out.println("Ending Damien's PreInitialization phase.");
		
	}
	
	public static void Initialization()
	{	
		
		System.out.println("Starting Damien's Initialization phase.");
		
		FileHandler fileHandler = new FileHandler();
		
		UrlHandler urlHandler = new UrlHandler();
		
		FileLoader fileLoader = new FileLoader();
		
		urlHandler.getAndProcessFromUrl("MSFT");
		
		Stock stock = fileLoader.getStockFromFile("Data\\Stocks\\MSFT", "MSFT All.csv", "MSFT");
		
		fileHandler.createFileFromStock(stock, "Test\\File", "test.csv");
		
		System.out.println("Ending Damien's Initialization phase.");
		
	}
	
	public static void postInitialization()
	{
		
		System.out.println("Starting Damien's PostInitialization phase.");
		
		System.out.println("Ending Damien's PostInitialization phase.");
		
	}

}
