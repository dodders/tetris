package com.gd.tetris;

import java.util.Properties;

import com.gd.tetris.controller.Controller;
import com.gd.tetris.model.Model;
import com.gd.tetris.view.View;

public class Main {

	Properties props;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.go();
	}
	
	public void go() {
		View v = new View();
		Model m = new Model();
		Controller c = new Controller(m,v);
		c.run();
	}

}
