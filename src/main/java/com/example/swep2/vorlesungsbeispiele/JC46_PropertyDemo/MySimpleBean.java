package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MySimpleBean {
	private IntegerProperty value;
	
	public MySimpleBean() {
		this(42);
	}
	
	public MySimpleBean(int sg) {
		System.out.println("im Konstruktor...");
		value = new SimpleIntegerProperty(this, "irgendein Wert", sg);
	}

	/**
	 * @return the value
	 */
	public final Integer getValue() {
		return value.getValue();
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(Integer value) {
		this.value.setValue(value);
	}
	
	/**
	 * @return the property itself
	 */
	public final IntegerProperty valueProperty() {
		return value;
	}

}
