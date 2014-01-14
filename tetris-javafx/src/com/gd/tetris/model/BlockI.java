package com.gd.tetris.model;

import javafx.scene.paint.Color;

public class BlockI extends GameObject {

	public BlockI() {
		color = Color.DARKRED;
		shape[1][0] = 1;
		shape[1][1] = 1;
		shape[1][2] = 1;
		shape[1][3] = 1;
	}
	
	@Override
	public void rotateRight() {
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
		shape[0][0] = 0;
	}

	@Override
	public void rotateLeft() {
		// TODO Auto-generated method stub
		
	}

}
