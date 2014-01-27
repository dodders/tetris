package com.gd.tetris.model;

public class Matrix {

	Tile[][] matrix;
	int rows, cols;

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.matrix = new Tile[rows][cols];
	}
	
	public Matrix clone() {
		Matrix to = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				to.setCell(r, c, this.getCell(r, c));
			}
		}
		return to;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int r = 0; r < rows; r++) {
			sb.append("{");
			for (int c = 0; c < cols; c++) {
				if (getCell(r, c) != null) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}
	
	public Tile getCell(int row, int col) {
		return matrix[row][col];
	}
	
	public void setCell(int row, int col, Tile cell) {
		matrix[row][col] = cell;
	}
	
	
	public void log(String msg) {
		System.out.println(msg);
	}
}
