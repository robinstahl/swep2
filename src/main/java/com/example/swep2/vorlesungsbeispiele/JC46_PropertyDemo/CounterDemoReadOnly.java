package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CounterDemoReadOnly {

	public static void main(String[] args) {
		Counter mcb = new Counter();
		
		mcb.rwcounterProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				System.out.println("InvalidationListener notified. Changed object is " + observable);
			}
		});

		mcb.rocounterProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("ChangeListener notified. Changed object is " + observable);
				System.out.println("Old value: " + oldValue + ", new value: " + newValue);
			}
		});
		
		System.out.println("*** Changing value of property now...");
		for (int i = 0; i < 10; i++)
			mcb.increment();
		
		System.out.println("\n*** calling some methods now...");
		System.out.println(mcb.rwcounterProperty().getName());
		System.out.println(mcb.rwcounterProperty().getBean());
		
		System.out.println("\n*** trying to set value...");
		mcb.rwcounterProperty().set(-10);
		System.out.println(mcb.rwcounterProperty());
		
		System.out.println("\n*** trying to set value of rocounter...");
		//mcb.rocounterProperty().set(-10); //gibt es nicht!
		System.out.println("... impossible, no set method!");
	}

}
