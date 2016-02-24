package io.github.poisonedporkchop.Xye.graphics;

import io.github.poisonedporkchop.Xye.data.files.FileHandler;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.opengl.ImageIOImageData;


/**
 * @author Damien Claessen
 */
public class DisplayHandler {
	
	public static int WIDTH,HEIGHT;
	
	public void create() {
		
		try {
			
			new FileHandler().createFolder("Resources\\Icon");
			
			Display.setIcon(new ByteBuffer[] {
					
				new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("C:\\Xye\\Resources\\Icon\\Icon16.png")), false, false, null),
				
				new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("C:\\Xye\\Resources\\Icon\\Icon32.png")), false, false, null)
				
			});
			
		} catch (IOException e) {
			
			System.out.println("WARNING: Could not load window icon!");
			
		}
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		Display.setInitialBackground(0, 0, 0);
		
		DisplayMode usedMode = new DisplayMode(600, 400);
					
		try {
			
			Display.setDisplayMode(usedMode);
			
			Display.create(new PixelFormat(), attribs);
		
		} catch (LWJGLException e1) {
			
			System.out.println("ERROR: Severe - Display could not be initialized correctly!");
			
			e1.printStackTrace();
			
		}
		
		WIDTH = usedMode.getWidth();
		
		HEIGHT = usedMode.getHeight();
		
		System.out.println("INFO: Creating Display");
		
	    System.out.println("OS: " + System.getProperty("os.name"));
		
		System.out.println("Screen Resolution: " + WIDTH + " * " + HEIGHT);
		
		System.out.println("Graphics: " + GL11.glGetString(GL11.GL_VENDOR) + " (" + Display.getVersion() + ")" + " : " + "Display: " + WIDTH + " * " + HEIGHT);
		
		System.out.println("Using OpenGL version " + GL11.glGetString(GL11.GL_VERSION) + (" (LWJGL: " + org.lwjgl.Sys.getVersion() + ")"));
		
		Display.setTitle("Xye");
		
	}
	
	public void update() {
		
		Display.sync(120);
		
		Display.update();
		
	}
	
	public void close() {
		
		Display.destroy();
		
	}

}
