/**
 * 
 */
package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Erich Müller
 *
 */
public class Counter {
	private IntegerProperty rwcounter;
	private ReadOnlyIntegerWrapper rocounter;

	public Counter() {
		this(0, 0);
	}
	
	public Counter(int rw, int ro) {
		rwcounter = new SimpleIntegerProperty(this, "read/write", rw);
		//readonly properties use the Wrapper:
		rocounter = new ReadOnlyIntegerWrapper(this, "readonly", ro);
	}
	
	//getter
	public int getRwcounter() {
		return rwcounter.get();
	}
	public int getRocounter() {
		return rocounter.get();
	}
	
	//setter
	public void increment() {
		rwcounter.set(rwcounter.get()+1);
		rocounter.set(rocounter.get()+1);
	}
	
	//return property itself
	public IntegerProperty rwcounterProperty() {
		return rwcounter;
	}
	public ReadOnlyIntegerProperty rocounterProperty() {
		return rocounter.getReadOnlyProperty();
	}
}
