package com.example.swep2.vorlesungsbeispiele.JC57_FXCollections;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ArrayChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class FXCDemo {

	/**
	 * Defines an observableArrayList with invalidation and change listeners. It
	 * populates the list, removes an entry, changes an entry and sorts the list.
	 * Listeners print the recognized events to the console.
	 */
	public static void arrayListDemo() {
		ObservableList<String> strings = FXCollections.observableArrayList();

		strings.addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				System.out.println("List invalidated: " + observable);
			}

		});

		strings.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> c) {
				System.out.println("Change: " + c.toString());
				while (c.next()) {
					if (c.wasPermutated())
						System.out.println("Permutation erkannt");
					if (c.wasAdded())
						System.out.println("Hinzufügen erkannt");
					if (c.wasRemoved())
						System.out.println("Entfernen erkannt");
					if (c.wasReplaced())
						System.out.println("Ersetzen erkannt");
					if (c.wasUpdated())
						System.out.println("Update erkannt");
				}
			}

		});

		strings.add("Hallo");
		strings.add("Welt!");
		strings.add("Pech");
		strings.add("Glueck");
		System.out.println("************");

		strings.remove(1);
		System.out.println("************");

		strings.set(1, "Leute");
		System.out.println("************");

		strings.sort((String s1, String s2) -> s1.compareTo(s2));
		System.out.println("************");
		for (String s : strings) {
			System.out.println(s);
		}

	}

	public static void mapDemo() {
		ObservableMap<String, Integer> map = FXCollections.observableHashMap();
		map.addListener((Observable o) -> {
			System.out.println("Map invalidated: " + o);
		});
		map.addListener(new MapChangeListener<String, Integer>() {
			@Override
			public void onChanged(Change<? extends String, ? extends Integer> change) {
				System.out.println("Change: " + change);
			}
		});
		map.put("Hallo", 5);
		map.put("Welt", 4);
		System.out.println("Value von Hallo: " + map.get("Hallo"));
		map.replace("Hallo", 7);
		map.remove("Hallo");
	}

	public static void arrayDemo() {
		ObservableIntegerArray oarray = FXCollections.observableIntegerArray();
		oarray.addListener(new ArrayChangeListener<ObservableIntegerArray>() {

			@Override
			public void onChanged(ObservableIntegerArray observableArray, boolean sizeChanged, int from, int to) {
				if (sizeChanged) {
					System.out.println("Groesse wurde geaendert von " + from + " auf " + to);
				} else {
					System.out.println(observableArray.toString() + " , " + from + ", " + to);
				}
			}

		});
		oarray.resize(10);
		for (int i = 0; i < oarray.size(); i++)
			oarray.set(i, i);
		oarray.resize(12);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//arrayListDemo();
		//mapDemo();
		arrayDemo();
	}

}
