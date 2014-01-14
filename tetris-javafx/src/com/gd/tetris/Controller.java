package com.gd.tetris;

import java.util.Observable;
import java.util.Observer;

import com.gd.tetris.model.GameObject;
import com.gd.tetris.model.Model;
import com.gd.tetris.model.Tile;
import com.sun.scenario.effect.impl.hw.RendererDelegate.Listener;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller implements Runnable, Observer {

	//TilePane view;
	GridPane view;
	Model model;
	Rectangle r;
	Rectangle prev;
	int rows;
	int cols;
	int currRow = 0, prevRow = 0;
	int currCol = 0, prevCol = 0;	
	
	public Controller(GridPane tp, int rows, int cols) {
		this.view = tp;
		this.rows = rows;
		this.cols = cols;
		model = new Model(rows, cols);
		model.init(this);
		updateView();
	}
	
	private void updateView() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Rectangle rect = new Rectangle(20,20,20,20);
				Tile t = model.tiles[r][c];
				rect.setFill(t.getColor());
				view.add(rect, c, r);
			}
		}
	}

	@Override
	public void run() {
		GameObject o = model.createBlock();
		for (int c = 0; c < 100; c++) {
			model.drawBlock(o, this, true);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			model.drawBlock(o, this, false);
			o.down();
		}
	}

	private void updateModel() {
		//switch currRow to aqua
		model.tiles[currRow][currCol].setColor(Color.AQUA);
		//next row
		currCol++;
		if (currCol == cols) {
			currCol = 0;
			currRow++;
			if (currRow == rows) {
				currRow = 0;
			}
		}
		model.tiles[currRow][currCol].setColor(Color.GREEN);
	}

	@Override
	public void update(Observable o, Object arg) {
		Tile t = (Tile)o;
		Platform.runLater(new UpdateCell(t));
	}
	
	public class UpdateCell implements Runnable {
		Tile t;
		
		public UpdateCell(Tile t) {
			this.t = t;
		}
		
		@Override
		public void run() {
			Rectangle r = new Rectangle(20,20,20,20);
			r.setFill(t.getColor());
			view.add(r, t.col, t.row);
		}
	}
}