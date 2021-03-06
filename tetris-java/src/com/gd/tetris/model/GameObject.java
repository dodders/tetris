package com.gd.tetris.model;

public abstract class GameObject {
	
	private int x;
	private int y;
	private int[][] shape;
	
	public void down() {
		y--;
		if (y < 0) {
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
