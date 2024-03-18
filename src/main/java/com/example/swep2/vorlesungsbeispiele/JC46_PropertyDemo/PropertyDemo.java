package com.example.swep2.vorlesungsbeispiele.JC46_PropertyDemo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableStringValue;

public class PropertyDemo {

	public static void main(String[] args) {
		IntegerProperty ip1 = new SimpleIntegerProperty();
		IntegerProperty ip2 = new SimpleIntegerProperty();
		ip1.set(100);
		
		//unidirectional binding:
		ip2.bind(ip1);
		
		System.out.println(ip1.get() + ", " + ip2.get());
		ip1.set(105);
		System.out.println(ip1.get() + ", " + ip2.get());
		
		//unbind ip2
		ip2.unbind();

		MySimpleBean bean = new MySimpleBean();

		//bidirectional binding:
		bean.valueProperty().bindBidirectional(ip2);

		ip2.set(43);
		System.out.println(ip2.get());
		System.out.println(bean.valueProperty().get());
		
		bean.valueProperty().set(-10);
		System.out.println(bean.getValue());
		System.out.println(ip2.getValue());
	}

}
