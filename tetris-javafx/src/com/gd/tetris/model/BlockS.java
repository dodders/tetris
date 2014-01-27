package com.gd.tetris.model;

import javafx.scene.paint.Color;
import com.gd.tetris.model.Tile;

public class BlockS extends GameObject {

	public BlockS(int row, int col) {
		super(3, 3);
		color = Color.DARKGREEN;
		shape.setCell(0, 1, new Tile(color));
		shape.setCell(0, 2, new Tile(color));
		shape.setCell(1, 0, new Tile(color));
		shape.setCell(1, 1, new Tile(color));
		this.row = row;
		this.col = col;
	}
}
