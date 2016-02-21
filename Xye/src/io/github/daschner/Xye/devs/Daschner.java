package io.github.daschner.Xye.devs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Daschner 
{
	public static ScriptEngineManager scriptEngineManager;
	public static ScriptEngine scriptEngine;
	public static void preInitialization()
	{
		
		System.out.println("Mr. Daschner's preinitialization has started.");
		
		System.out.println("Starting up java script engine manager...");
		scriptEngineManager = new ScriptEngineManager();
		System.out.println("Started successfully.");
		
		System.out.println("Starting up java script engine...");
	    scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
	    System.out.println("Started successfully.");
	    
		System.out.println("Mr. Daschner's preinitialization has completed.");
	}
	
	public static void Initialization()
	{
		System.out.println("Mr. Daschner's initialization has started.");
		testInitialization();
		System.out.println("Mr. Daschner's initialization has completed.");
	}
	
	public static void postInitialization()
	{
		System.out.println("Mr. Daschner's postinitialization has started.");
		
		System.out.println("Mr. Daschner's postinitialization has completed.");
	}
	
	public static void testInitialization()
	{
		System.out.println("Mr. Daschner's initialization testing has started.");
		
		System.out.println("Mr. Daschner's initialization testing has completed.");
	}

}
