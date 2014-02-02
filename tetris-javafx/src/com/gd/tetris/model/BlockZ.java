package com.gd.tetris.model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BlockZ extends GameObject {

	public BlockZ(int row, int col) {
		super(3, 3);
		color = Color.DARKCYAN;
		this.image = new Image("ZBlock.png");
		shape.setCell(0, 0, new Tile(image));
		shape.setCell(0, 1, new Tile(image));
		shape.setCell(1, 1, new Tile(image));
		shape.setCell(1, 2, new Tile(image));
		this.row = row;
		this.col = col;
	}
}
