package io.github.daschner.Xye;

import io.github.daschner.Xye.devs.Damien;
import io.github.daschner.Xye.devs.Daschner;
/**
 * @author Mr. Daschner
 */
public class Xye {

	public static void main(String[] args) 
	{		
		Daschner.preInitialization();
		Damien.preInitialization();
		
		Daschner.Initialization();
		Damien.Initialization();
		
		Damien.postInitialization();
		Daschner.postInitialization();
	}

}
