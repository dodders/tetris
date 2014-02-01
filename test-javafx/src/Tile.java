import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Tile {
	
	public IntegerProperty row = new SimpleIntegerProperty();
	public IntegerProperty col = new SimpleIntegerProperty();
	private String colour = new String();
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		System.out.println("tile colour changed.");
		String old = colour;
		this.colour = colour;
		this.pcs.firePropertyChange("colour", old, colour);
		/*if (pcs.hasListeners("colour")) {
			System.out.println("has property listeners...");
			PropertyChangeListener[] pcl = pcs.getPropertyChangeListeners();
			pcl[0].propertyChange(new PropertyChangeEvent(this, "colour",old,colour));
		}*/
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
        System.out.println("tile property listener added.");
    }

	public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

}
