package io.github.daschner.Xye.devs;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Month;
import io.github.daschner.Xye.data.url.UrlHandler;
import io.github.poisonedporkchop.data.files.FileHandler;

import java.net.URL;

public class Damien 
{
	
	public static int x;
	
	//Libraries and APIs
	public static void preInitialization()
	{
		
		System.out.println("Starting PP PreInitialization phase.");
		
		System.out.println("Ending PP PreInitialization phase.");
		
	}
	
	public static void Initialization()
	{	
		
		System.out.println("Starting PP Initialization phase.");
		
		UrlHandler urlHandler = new UrlHandler();
		
		FileHandler fileHandler = new FileHandler();
		
		for(int i = 0; i < 31; i++) {
		
		Date date = new Date(i+1, Month.DECEMBER, 2015);
		
		URL url = urlHandler.getStockUrlForDate("IXIC", date);
		
		if(urlHandler.validateURL(url)) {
			
			urlHandler.downloadFileFromURL(url, "Downloads\\Stocks\\IXIC", (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + ".csv");
			
		}
		else
		{
			
			System.out.println("WARNING: Could not download '" + (date.getMonth().ordinal() + 1) + "-" + date.getDay() + "-" + date.getYear() + "' as it was not available.");
			
		}
		
		}
		
		fileHandler.processTrade("Downloads\\Stocks\\IXIC", "Data\\Stocks\\IXIC") ;
		
		System.out.println("Ending PP Initialization phase.");
		
	}
	
	public static void postInitialization()
	{
		
		System.out.println("Starting PP PostInitialization phase.");
		
		System.out.println("Ending PP PostInitialization phase.");
		
	}

}
