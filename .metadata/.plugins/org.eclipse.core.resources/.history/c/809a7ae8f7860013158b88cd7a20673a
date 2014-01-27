package com.gd.tetris.model;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Random;

import javafx.scene.paint.Color;

public class Model{
	
	public Matrix tiles;
	public int rows;
	public int cols;
	public Color background = Color.AQUA;
	GameObject block = null;
	Observer observer;
	public enum DrawType {
		Draw, Erase;
	}
	private Random random;
	
	public Model(int rows, int cols, Observer o) {
		this.rows = rows;
		this.cols = cols;
		this.observer = o;
		tiles = new Matrix(rows, cols);
		random = new Random();
	}
	
	public void init(Observer o) {
		
		log("creating " + rows * cols + " tiles.");
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Tile t = new Tile(background);
				t.row = r;
				t.col = c;
				t.setColor(background);
				t.addObserver(o);
				tiles.setCell(r, c, t);
			}
		}
	}
	
	public GameObject getBlock() {
		return block;
	}
	
	public void newBlock() {
		int n = random.nextInt(7);
		switch(n) {
			case 0 :block = new BlockI(0, 3); break;
			case 1 :block = new BlockJ(0, 3); break;
			case 2 :block = new BlockL(0, 3); break;
			case 3 :block = new BlockO(0, 3); break;
			case 4 :block = new BlockS(0, 3); break;
			case 5 :block = new BlockT(0, 3); break;
			case 6 :block = new BlockZ(0, 3); break;
		}
		this.drawBlock(block);
	}
	
	public boolean blockDown() {
		removeBlock(block);
		if (block.down(rows)) {
			if (drawBlock(block)) {
				return true;
			} else {
				block.up();
				drawBlock(block);
			}
		} else {
			drawBlock(block);
			return false;
		}
		return false;
	}
	

	public boolean blockRight() {
		removeBlock(block);
		if (block.right(cols)) {
			if(drawBlock(block)) {
				return true;
			} else {
				block.left();
				drawBlock(block);
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean blockLeft() {
		removeBlock(block);
		if (block.left()) {
			if (drawBlock(block)) {
				return true;
			} else {
				block.right(cols);
				drawBlock(block);
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean rotateBlockLeft() {
		removeBlock(block);
		block.rotateLeft();
		if (drawBlock(block)) {
			return true;
		} else {
			block.rotateRight();
			drawBlock(block);
			return false;
		}
	}
	
	public boolean drawBlock(GameObject obj) {
		boolean drawn = true;
		Matrix m = obj.getShape();
		ArrayList<Tile> changed = new ArrayList<>();
		for (int r = 0; r < m.rows; r++) {
			for (int c = 0; c < m.cols; c++) {
				if (m.getCell(r, c) != null) {
					int newRow = obj.getRow() + r;
					int newCol = obj.getCol() + c;
					if (newRow >= rows || newCol >= cols) {
						drawn = false;
						break;
					}
					Tile t = tiles.getCell(newRow, newCol);
					if (t.getColor() == background) {
						changed.add(t);
						t.setColor(m.getCell(r, c).getColor());
					} else {
						drawn = false;
						break;
					}
				}
			}
		}
		if (drawn) {
			return true;
		} else {
			for (Tile t : changed) {
				t.setColor(background);
			}
			return false;
		}
	}
	
	public void removeBlock(GameObject obj) {
		Matrix m = obj.getShape();
		for (int r = 0; r < m.rows; r++) {
			for (int c = 0; c < m.cols; c++) {
				if (m.getCell(r, c) != null) {
					if (obj.getRow() + r < rows || obj.getCol() + c < cols) {
						Tile t = tiles.getCell(obj.getRow() + r, obj.getCol() + c);
						t.setColor(background);
					}
				}
			}
		}
	}

/*	public void drawBlock(GameObject b, DrawType type) {
		Matrix<Tile> blockMap = b.getShape();
		for (int r = 0; r < blockMap.rows; r++) {
			for (int c = 0; c < blockMap.cols; c++) {
				if (blockMap.getCell(r, c) != null) {
					Tile t = new Tile();
					t.row = b.getRow() + r;
					t.col = b.getCol() + c;
					t.addObserver(o);
					if (type == DrawType.Draw) {
						t.setColor(b.getColor());
					} else {
						t.setColor(background);
					}
					tiles.setCell(r, c, t);
				}
			}
		}
	}*/
	
	private void log(String msg) {
		System.out.println(msg);
	}
}
