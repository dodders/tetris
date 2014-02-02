package com.gd.tetris.model;

import javafx.scene.image.Image;

public class BlockL extends GameObject {

	public BlockL(int row, int col) {
		super(3, 3);
		this.row = row;
		this.col = col;
		this.image = new Image("LBlock.png");
		shape.setCell(0, 0, new Tile(image));
		shape.setCell(1, 0, new Tile(image));
		shape.setCell(2, 0, new Tile(image));
		shape.setCell(2, 1, new Tile(image));
	}
}
