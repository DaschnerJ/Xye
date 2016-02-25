package io.github.daschner.Xye.devs;

import org.lwjgl.opengl.Display;

import io.github.daschner.Xye.data.url.UrlHandler;
import io.github.poisonedporkchop.Xye.data.files.FileHandler;
import io.github.poisonedporkchop.Xye.data.files.FileLoader;
import io.github.poisonedporkchop.Xye.graphics.DisplayHandler;

public class Damien 
{
	
	public static FileHandler fileHandler = new FileHandler();
	
	public static FileLoader fileLoader = new FileLoader();
	
	public static UrlHandler urlHandler = new UrlHandler();
	
	public static DisplayHandler displayHandler = new DisplayHandler();
	
	//Libraries and APIs
	public static void preInitialization()
	{
		
		System.out.println("Starting Damien's PreInitialization phase.");
		
		System.out.println("Ending Damien's PreInitialization phase.");
		
	}
	
	public static void Initialization()
	{	
		
		System.out.println("Starting Damien's Initialization phase.");
		
		urlHandler.getAndProcessFromUrl("MSFT");
		
		fileLoader.getStockFromFile("Data\\Stocks\\MSFT", "MSFT", "MSFT");
		
		new Damien().startProgram();
		
		System.out.println("Ending Damien's Initialization phase.");
		
	}
	
	public static void postInitialization()
	{
		
		System.out.println("Starting Damien's PostInitialization phase.");
		
		System.out.println("Ending Damien's PostInitialization phase.");
		
	}
	
	public void startProgram() {
		
		System.out.println("INFO: Starting program!");
		
		displayHandler.create();
		
		programLoop();
		
	}
	
	public void programLoop() {
		
		while(!Display.isCloseRequested()) {
			
			displayHandler.update();
			
		}
		
		stopProgram();
		
	}
	
	public void stopProgram() {
		
		displayHandler.close();
		
	}

}
