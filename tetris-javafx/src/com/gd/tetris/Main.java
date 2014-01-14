package com.gd.tetris;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import com.gd.tetris.model.Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	//TilePane gridView = new TilePane();
	GridPane gridView = new GridPane();
	BorderPane bp = new BorderPane();
	Properties props = new Properties();
	int rows;
	int cols;
	Controller controller;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		create();
		primaryStage.setTitle("Tetris - JavaFX");
		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();
		new Thread(controller).start();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void create() throws IOException {
		log("starting...");
		Path p = FileSystems.getDefault().getPath("tetris.properties");
		log(p.toAbsolutePath().toString());
		InputStream is = Files.newInputStream(p, StandardOpenOption.READ);
		props.load(is);
		rows = Integer.parseInt(props.getProperty("height"));
		cols = Integer.parseInt(props.getProperty("width"));
		//set up screen
		bp.setCenter(gridView);
		gridView.setHgap(2);
		gridView.setVgap(2);
		controller = new Controller(gridView, rows, cols);
	}
	
	private void log(String msg) {
		System.out.println(msg);
	}
	
}