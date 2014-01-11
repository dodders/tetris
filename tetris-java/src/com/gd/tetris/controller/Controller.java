package com.gd.tetris.controller;

import com.gd.tetris.model.Model;
import com.gd.tetris.view.View;

public class Controller {
	
	private View view;
	private Model model;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void init() {
		
	}
	
	public void run() {
		log("starting...");
		init();
	}
	
	private void log(String msg) {
		System.out.println(msg);
	}

}
