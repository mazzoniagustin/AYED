package ttp1.ejercicio8;
import java.util.*;

public class Queue<T> {
	private List<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	

}
