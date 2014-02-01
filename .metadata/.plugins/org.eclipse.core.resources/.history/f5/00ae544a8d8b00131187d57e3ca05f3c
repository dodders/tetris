package com.gd.tetris.model;

import javafx.scene.paint.Color;

public abstract class GameObject {
	
	protected int col, row;
	protected int cols, rows;
	protected Matrix shape;
	protected Color color;
	protected int angle;
	
	public enum Rotation { 
		Right, 
		Left; 
	}
	
	public GameObject(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		shape = new Matrix(rows, cols);
		angle = 0;
	}
	
	private void rotate(Rotation dir) {
		Matrix m = new Matrix(rows, cols);
		if (dir == Rotation.Right) {
			int tcol = cols - 1;
			for (int r = 0; r < rows; r++) {
				int trow = 0;
				for (int c = 0; c < cols; c++) {
					m.setCell(trow, tcol, shape.getCell(r, c));
					trow++;
				}
				tcol--;
			}
			angle = angle + 90;
		} else {
			int tcol = 0;
			for (int r = 0; r < rows; r++) {
				int trow = rows - 1;
				for (int c = 0; c < cols; c++) {
					m.setCell(trow, tcol, shape.getCell(r, c));
					trow--;
				}
				tcol++;
			}
		}
		angle = angle - 90;
		this.shape = m;
	}

	
	public boolean down(int maxRow) {
		if (row < maxRow - 1) {
			row++;
			return true;
		} else {
			return false;
		}
	}
	
	public void up() {
		if (row > 1) {
			row--;
		}
	}
	
	public boolean left() {
		if (col > 0) {
			col--;
			return true;
		} else {
			return false;
		}
	}

	public boolean right(int maxCol) {
		if (col < maxCol) {
			col++;
			return true;
		} else {
			return false;
		}
	}
	
	public void rotateRight() {
		rotate(Rotation.Right);
	}
	
	public void rotateLeft() {
		rotate(Rotation.Left);
	}
	
	public Color getColor() {
		return this.color;
	}

	public Matrix getShape() {
		return shape;
	}

	public void setShape(Matrix shape) {
		this.shape = shape;
	}

	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	private void log(String msg) {
		System.out.println(msg);
	}
	
	public String toString() {
		return this.row + ":" + this.col + ":" + shape.toString();
	}

}
