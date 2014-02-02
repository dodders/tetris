package com.gd.tetris.model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BlockT extends GameObject {

	public BlockT(int row, int col) {
		super(3, 3);
		color = Color.BROWN;
		this.image = new Image("TBlock.png");
		shape.setCell(0, 0, new Tile(image));
		shape.setCell(0, 1, new Tile(image));
		shape.setCell(0, 2, new Tile(image));
		shape.setCell(1, 1, new Tile(image));
		this.row = row;
		this.col = col;
	}
}
