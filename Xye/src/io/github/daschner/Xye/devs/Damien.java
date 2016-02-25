package io.github.daschner.Xye.devs;

import io.github.daschner.Xye.data.url.UrlHandler;
import io.github.poisonedporkchop.Xye.data.files.FileHandler;
import io.github.poisonedporkchop.Xye.data.files.FileLoader;
import io.github.poisonedporkchop.Xye.graphics.DisplayHandler;
import io.github.poisonedporkchop.Xye.graphics.gui.GUI;

import java.net.MalformedURLException;
import java.net.URL;

import org.lwjgl.opengl.Display;

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
		
		try {
			
			URL url = new URL("http://s16.postimg.org/6gke1cl01/Icon16.png");
			
			System.out.println(url);
			
			urlHandler.downloadFileFromURL(new URL("http://i.imgur.com/ylHaECC.png"), "Resources\\Icon", "Icon16", "png");
			
			urlHandler.downloadFileFromURL(new URL("http://i.imgur.com/iYgKfGF.png"), "Resources\\Icon", "Icon32", "png");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		displayHandler.create();
		
		programLoop();
		
	}
	
	public void programLoop() {
		
		float[] vertices = {-0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f, 0.5f, 0f
		};
		
		GUI gui = new GUI(vertices);
		
		while(!Display.isCloseRequested()) {
			
			displayHandler.prepare();
			
			displayHandler.renderGUI(gui);
			
			displayHandler.update();
			
		}
		
		stopProgram();
		
	}
	
	public void stopProgram() {
		
		displayHandler.cleanUp();
		
		displayHandler.close();
		
	}

}
