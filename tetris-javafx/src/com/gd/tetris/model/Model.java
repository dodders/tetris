package com.gd.tetris.model;

import java.util.Observer;

import javafx.scene.paint.Color;

public class Model {
	
	public Tile [][] tiles ;
	public int rows;
	public int cols;
	GameObject shape = null;
	
	public Model(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		tiles = new Tile[rows][cols];
	}
	
	public void init(Observer o) {
		
		log("creating " + rows * cols + " tiles.");
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Tile t = new Tile();
				t.row = r;
				t.col = c;
				t.setColor(Color.AQUA);
				t.addObserver(o);
				tiles[r][c] = t;
			}
		}
	}
	
	public GameObject getBlock() {
		return shape;
	}
	
	public GameObject createBlock() {
		return new BlockL();
	}
	
	public void drawBlock(GameObject b, Observer o, boolean draw) {
		int[][] blockMap = b.getShape();
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 4; c++) {
				if (blockMap[r][c] == 1) {
					Tile t = new Tile();
					t.row = b.getY() + r;
					t.col = b.getX() + c;
					t.addObserver(o);
					if (draw) {
						t.setColor(b.getColor());
					} else {
						t.setColor(Color.AQUA);
					}
					tiles[t.row][t.col] = t;
				}
			}
		}

	}
	
	private void log(String msg) {
		System.out.println(msg);
	}

}
