package io.github.daschner.Xye.devs;

public class Daschner 
{
	public static void preInitialization()
	{
		System.out.println("Mr. Daschner's preinitialization has started.");
		
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
