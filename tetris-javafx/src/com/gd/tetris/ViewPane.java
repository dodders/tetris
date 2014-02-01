package com.gd.tetris;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ViewPane extends GridPane {
	
	Node[][] nodes;
	int rows;
	int cols;
	
	public ViewPane(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		nodes = new Node[rows][cols];
	}
	
	@Override
	public void add(Node child, int columnIndex, int rowIndex) {
		super.add(child, columnIndex, rowIndex);
		nodes[rowIndex][columnIndex] = child;
	}
	
	public Node get(int row, int col) {
		return nodes[row][col];
	}
	
}
