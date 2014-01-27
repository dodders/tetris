package com.gd.tetris;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import com.gd.tetris.model.Model;
import com.gd.tetris.model.Tile;

public class Controller implements Runnable, Observer, EventHandler<KeyEvent> {

	//TilePane view;
	GridPane view;
	Model model;
	Rectangle r;
	Rectangle prev;
	int rows;
	int cols;
	int currRow = 0, prevRow = 0;
	int currCol = 0, prevCol = 0;	
	HashMap<KeyCode, Boolean> keys = new HashMap<>();
	Map<KeyCode, Boolean> keyMap = Collections.synchronizedMap(keys);
	
	public Controller(GridPane tp, int rows, int cols) {
		this.view = tp;
		this.rows = rows;
		this.cols = cols;
		model = new Model(rows, cols, this);
		model.init(this);
		createView();
		keys.put(KeyCode.LEFT, false);
		keys.put(KeyCode.RIGHT, false);
		keys.put(KeyCode.UP, false);
		keys.put(KeyCode.DOWN, false);
	}
	
	private void createView() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Rectangle rect = new Rectangle(20,20,20,20);
				Tile t = model.tiles.getCell(r, c);
				rect.setFill(t.getColor());
				view.add(rect, c, r);
			}
		}
	}

	@Override
	public void run() {
		model.newBlock();
		while(true) {
			pause();
			if (model.blockDown()) {
				doKeys();
			} else {
				model.newBlock();
			}
		}
	}

	private void pause() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void doKeys() {
		//System.out.println(keyMap.toString());
		if (keyMap.get(KeyCode.RIGHT)) {
			model.blockRight();
			keyMap.put(KeyCode.RIGHT, false);
		} else if (keyMap.get(KeyCode.LEFT)) {
			model.blockLeft();
			keyMap.put(KeyCode.LEFT, false);
		} else if (keyMap.get(KeyCode.UP)) {
			model.rotateBlockLeft();
			keyMap.put(KeyCode.UP, false);
		}
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
	
	@Override
	public void handle(KeyEvent event) {
		if (keys.containsKey(event.getCode())) {
			if (event.getEventType() == KeyEvent.KEY_PRESSED) {
				keys.put(event.getCode(), true);
			}
		}
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}
}
