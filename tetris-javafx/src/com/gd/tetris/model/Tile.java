package com.gd.tetris.model;

import java.util.Observable;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Tile extends Observable {

	public int row;
	public int col;
	private Image image;
	
	public Tile(Image i) {
		super();
		this.setImage(i);
	}
	
	public Tile() {
		super();
	}
	
	public String toString() {
		return "tile:" + row + ":" + col;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		setChanged();
		notifyObservers();
	}
}
