package io.github.poisonedporkchop.Xye.graphics;

import io.github.poisonedporkchop.Xye.data.files.FileHandler;
import io.github.poisonedporkchop.Xye.graphics.gui.GUI;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.opengl.ImageIOImageData;


/**
 * @author Damien Claessen
 */
public class DisplayHandler {
	
	public static int WIDTH,HEIGHT;
	
	public static List<Integer> vaos = new ArrayList<Integer>();
	public static List<Integer> vbos = new ArrayList<Integer>();
	
	public void create() {
		
		Display.setResizable(true);
		
		Display.setTitle("Xye");
		
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
		DisplayMode usedMode = new DisplayMode(Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
		Display.setLocation(-3, 0);
					
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
		
	}
	
	public void prepare() {
		
		GL11.glClearColor(0, 0, 1, 1);
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
	}
	
	public void update() {
		
		Display.sync(120);
		
		Display.update();
		
	}
	
	public void close() {
		
		Display.destroy();
		
	}
	
	public void renderGUI(GUI gui) {
		
		GL30.glBindVertexArray(gui.getVAO());
		
		GL20.glEnableVertexAttribArray(0);
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, gui.getVertexCount());
		
		GL20.glDisableVertexAttribArray(0);
		
		GL30.glBindVertexArray(0);
		
	}
	
	public void cleanUp() {
		
		for(int vao : vaos) {
			
			GL30.glDeleteVertexArrays(vao);
			
		}
		
		for(int vbo : vbos) {
			
			GL15.glDeleteBuffers(vbo);
			
		}
		
	}

}
