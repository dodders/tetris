package com.gd.tetris.model;

import javafx.scene.image.Image;

public class BlockI extends GameObject {

	public BlockI(int row, int col) {
		super(4, 4);
		this.image = new Image("IBlock.png");
		shape.setCell(0, 0, new Tile(image));
		shape.setCell(0, 1, new Tile(image));
		shape.setCell(0, 2, new Tile(image));
		shape.setCell(0, 3, new Tile(image));
		this.row = row;
		this.col = col;
	}
}
