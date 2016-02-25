package io.github.poisonedporkchop.Xye.graphics.gui;

import io.github.poisonedporkchop.Xye.graphics.DisplayHandler;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * @author Damien Claessen
 */
public class GUI {
	
	private int vao = 0, vertexCount = 0;
	
	public GUI(float[] positions) {
		
		vao = createVAO(); 
		
		DisplayHandler.vaos.add(vao);
		
		storeData(0, positions);
		
		this.vertexCount = positions.length/3;
		
		closeVAO();
		
	}
	
	public int getVAO() {
		return vao;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
	private int createVAO() {
		
		int vao = GL30.glGenVertexArrays();
		
		GL30.glBindVertexArray(vao);
		
		return vao;
		
	}
	
	private void closeVAO() {
		
		GL30.glBindVertexArray(0);
		
	}
	
	private void storeData(int slot, float[] data) {
		
		int vbo = GL15.glGenBuffers();
		
		DisplayHandler.vbos.add(vbo);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		
		FloatBuffer buffer = arrayToBuffer(data);
		
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
		GL20.glVertexAttribPointer(slot, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
	}
	
	private FloatBuffer arrayToBuffer(float[] data) {
		
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		
		buffer.put(data);
		
		buffer.flip();
		
		return buffer;
		
	}
	
}
