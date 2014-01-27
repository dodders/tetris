package com.gd.tetris.model;

import javafx.scene.paint.Color;

public class BlockI extends GameObject {

	public BlockI(int row, int col) {
		super(4, 4);
		color = Color.DARKRED;
		shape.setCell(0, 0, new Tile(color));
		shape.setCell(0, 1, new Tile(color));
		shape.setCell(0, 2, new Tile(color));
		shape.setCell(0, 3, new Tile(color));
		this.row = row;
		this.col = col;
	}
}
