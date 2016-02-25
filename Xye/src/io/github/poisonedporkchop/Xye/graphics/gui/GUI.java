package io.github.poisonedporkchop.Xye.graphics.gui;

/**
 * @author Damien Claessen
 */
public class GUI {
	
	private int vao, vertexCount;
	
	public GUI(int vao, int vertexCount) {
		
		this.vao = vao;
		
		this.vertexCount = vertexCount;
		
	}
	
	public int getVAO() {
		return vao;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
}
