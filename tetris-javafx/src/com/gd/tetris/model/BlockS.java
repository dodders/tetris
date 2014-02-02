package com.gd.tetris.model;

import javafx.scene.image.Image;

public class BlockS extends GameObject {

	public BlockS(int row, int col) {
		super(3, 3);
		this.image = new Image("SBlock.png");
		shape.setCell(0, 1, new Tile(image));
		shape.setCell(0, 2, new Tile(image));
		shape.setCell(1, 0, new Tile(image));
		shape.setCell(1, 1, new Tile(image));
		this.row = row;
		this.col = col;
	}
}
