package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class HighLevelAPIDemo {

	public static void main(String[] args) {
		IntegerProperty ip1 = new SimpleIntegerProperty(100);
		IntegerProperty ip2 = new SimpleIntegerProperty(200);
		
		
		
		//using the Binding class:
		NumberBinding sum = Bindings.add(ip1, ip2);
		sum.addListener(o -> System.out.println("sum ist invalidiert!"));
//		sum.addListener((o,ov,nv) -> System.out.println(ov + ", " + nv));
		System.out.println("sum.get() -> " + sum.getValue());
		//change ip1:
		ip1.set(500);
		//change ip2: invalidation will not be fired again!!!
		ip2.set(1000);
		//lazy evaluation -> sum is invalid
		System.out.println("Sum: " + sum);
		System.out.println("sum.getValue() -> " + sum.getValue());
		//after computing the value due to its request in previous line -> sum is valid
		System.out.println("Sum: " + sum);
		
		//unbind ip2
		ip2.unbind();
		System.out.println("*************");
		
		//unidirectional binding with computation
		ip1.set(100);
		ip2.bind(Bindings.add(ip1, 2));
		System.out.println(ip1.get() + ", " + ip2.get());
		ip1.set(110);
		System.out.println(ip1.get() + ", " + ip2.get());

	}
}
