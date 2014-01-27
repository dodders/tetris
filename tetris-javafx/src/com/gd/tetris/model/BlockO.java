package com.gd.tetris.model;

import javafx.scene.paint.Color;
import com.gd.tetris.model.Tile;

public class BlockO extends GameObject {

	public BlockO(int row, int col) {
		super(2, 2);
		color = Color.DARKBLUE;
		shape.setCell(0, 0, new Tile(color));
		shape.setCell(0, 1, new Tile(color));
		shape.setCell(1, 0, new Tile(color));
		shape.setCell(1, 1, new Tile(color));
		this.row = row;
		this.col = col;
	}
}
