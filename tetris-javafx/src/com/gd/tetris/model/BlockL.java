package com.gd.tetris.model;

import javafx.scene.paint.Color;
import com.gd.tetris.model.Tile;

public class BlockL extends GameObject {

	public BlockL(int row, int col) {
		super(3, 3);
		color = Color.DARKMAGENTA;
		shape.setCell(0, 0, new Tile(color));
		shape.setCell(1, 0, new Tile(color));
		shape.setCell(2, 0, new Tile(color));
		shape.setCell(2, 1, new Tile(color));
		this.row = row;
		this.col = col;
	}
}
