package io.github.poisonedporkchop.Xye.graphics.gui;

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
