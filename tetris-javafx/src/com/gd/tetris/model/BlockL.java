package com.gd.tetris.model;

import javafx.scene.paint.Color;

public class BlockL extends GameObject {

	public BlockL() {
		color = Color.DARKBLUE;
		shape[0][0] = 1;
		shape[1][0] = 1;
		shape[1][1] = 1;
		shape[1][2] = 1;
		x = 3;
		y = 0;
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
