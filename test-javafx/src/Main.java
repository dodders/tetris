
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private TextField t1;
	private TextField t2;
	private Label l3;
	private Label l4;
	DoubleProperty total = new SimpleDoubleProperty();
	DoubleProperty d1 = new SimpleDoubleProperty();
	DoubleProperty d2 = new SimpleDoubleProperty();
	Tile t = new Tile();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Test");
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox, 400, 400);
		Label l0 = new Label("adder");
		t1 = new TextField();
		t2 = new TextField();
		l3 = new Label();
		l4 = new Label();
		d1.set(0);
		d2.set(0);
		total.set(0);
		t1.textProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> arg0, Object oldObj, Object newObj) {
				d1.set(Double.parseDouble(newObj.toString()));
				t.row.set(Integer.parseInt(newObj.toString()));
			}});
		t2.textProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> arg0, Object oldObj, Object newObj) {
				d2.set(Double.parseDouble(newObj.toString()));
				t.col.set(Integer.parseInt(newObj.toString()));
			}
		});	
		total.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				l3.setText("Total:" + newValue);
				log("setting tile colour...");
				t.setColour("total for tile is " + newValue);
			}
		});
		d1.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				total.set(d1.get() + d2.get());
			}
		});
		d2.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				total.set(d1.get() + d2.get());
			}
		});
		t.col.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue,
					Object newValue) {
				l4.setText("Sum is " + d1 + " + " + d2);
			}
		});
		t.row.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue,
					Object newValue) {
				l4.setText("Sum is " + d1 + " + " + d2);
			}
		});		
		vbox.getChildren().add(l0);
		vbox.getChildren().add(t1);
		vbox.getChildren().add(t2);
		vbox.getChildren().add(l3);
		vbox.getChildren().add(l4);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void log(String msg) {
		System.out.println(msg);
	}
}