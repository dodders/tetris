package com.gd.tetris;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import com.gd.tetris.model.Model;
import com.gd.tetris.model.Tile;

public class Controller implements Runnable, Observer, EventHandler<KeyEvent> {

	ViewPane view;
	Model model;
	Rectangle r;
	Rectangle prev;
	int rows;
	int cols;
	int currRow = 0, prevRow = 0;
	int currCol = 0, prevCol = 0;	
	HashMap<KeyCode, Boolean> keys = new HashMap<>();
	Map<KeyCode, Boolean> keyMap = Collections.synchronizedMap(keys);
	DownTimer downTimer;
	boolean finished = false;
	
	public Controller(ViewPane tp, int rows, int cols) {
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
		keys.put(KeyCode.SPACE, false);
		downTimer = new DownTimer(model);
	}
	
	private void createView() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ImageView iv = new ImageView();
				Tile t = model.tiles.getCell(r, c);
				iv.setImage(t.getImage());
				iv.setFitHeight(25);
				iv.setFitWidth(25);
				iv.setCache(true);
				view.add(iv, c, r);
			}
		}
	}
	
	@Override
	public void run() {
		model.newBlock();
		Thread t = new Thread(downTimer);
		t.start();
		while(true) {
			doKeys();
			if (model.isFinished()) {
				doFinished();
				System.exit(0);
			}
		}
	}
	
	private void doFinished() {
		
	}

	private void doKeys() {
		if (keyMap.get(KeyCode.RIGHT)) {
			model.blockRight();
			keyMap.put(KeyCode.RIGHT, false);
		} else if (keyMap.get(KeyCode.LEFT)) {
			model.blockLeft();
			keyMap.put(KeyCode.LEFT, false);
		} else if (keyMap.get(KeyCode.UP)) {
			model.rotateBlockLeft();
			keyMap.put(KeyCode.UP, false);
		} else if (keyMap.get(KeyCode.SPACE)) {
			model.dropBlock();
			keyMap.put(KeyCode.SPACE, false);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Tile t = (Tile)o;
		Platform.runLater(new UpdateCell(t));
	}
	
	public class PrintNodes implements Runnable {

		ObservableList<Node> l;
		public PrintNodes(ObservableList<Node> l) {
			this.l = l;
		}
		@Override
		public void run() {
			int c = 0;
			for (Node n : l) {
				Rectangle r = (Rectangle)n;
				log("rectangle " + c + " is colour " + r.getFill().toString());
			}
		}
		
	}
	
	public class DownTimer implements Runnable {

		Model m;
		int millis = 700;
		
		public DownTimer(Model m) {
			this.m = m;
		}

		@Override
		public void run() {
			while(true) {
				if (!m.blockDown()) {
					boolean n = m.newBlock();
					if (!n) {
						model.setFinished(true);
						return;
					}
				}
				m.eraseFullRows();
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class UpdateCell implements Runnable {
		Tile t;
		
		public UpdateCell(Tile t) {
			this.t = t;
		}
		
		@Override
		public void run() {
			ImageView iv = (ImageView)view.get(t.row, t.col);
			iv.setImage(t.getImage());
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
