package com.example.swep2.vorlesungsbeispiele.JC11_BoundedWildcards;


public class Node<T extends A> {

	private T item;
	
	Node(T item) {
		setItem(item);
	}
	
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
}
