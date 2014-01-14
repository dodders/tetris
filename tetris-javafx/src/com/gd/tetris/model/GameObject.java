package com.gd.tetris.model;

import javafx.scene.paint.Color;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected int[][] shape = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	protected Color color;
	protected int orient = 0; 
	
	public void down() {
		y++;
		if (y == 20) {
			y = 0;
		}
	}
	
	public void left() {
		x--;
		if (x < 0) {
			x = 0;
		}
	}
	
	abstract public void rotateRight();
	
	abstract public void rotateLeft();
	
	public void right() {
		x++;
	}
	
	public Color getColor() {
		return this.color;
	}

	public int[][] getShape() {
		return shape;
	}

	public void setShape(int[][] shape) {
		this.shape = shape;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
