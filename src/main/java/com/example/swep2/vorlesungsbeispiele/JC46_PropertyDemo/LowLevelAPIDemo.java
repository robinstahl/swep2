package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LowLevelAPIDemo {

    public static void main(String[] args) {
    	 
        final DoubleProperty a = new SimpleDoubleProperty(1);
        final DoubleProperty b = new SimpleDoubleProperty(2);
        final DoubleProperty c = new SimpleDoubleProperty(3);
        final DoubleProperty d = new SimpleDoubleProperty(4);
 
        DoubleBinding db = new DoubleBinding() {
 
            {
                super.bind(a, b, c, d);
            }
 
            @Override
            protected double computeValue() {
                return (a.get() * b.get()) + (c.get() * d.get());
            }
            
            @Override
            public ObservableList<?> getDependencies() {
            	ObservableList<Object> ol = FXCollections.observableArrayList();
            	ol.addAll(a,b,c,d);
                return ol;
            }
            	
        };
 
        System.out.println(db.get());
        b.set(5);
        if(!db.isValid())
        	System.out.println("binding is invalid -> lazy evaluation");
        System.out.println(db.get());
        for (Object dp : db.getDependencies()) {
        	System.out.println(dp);
        }
    }

}
