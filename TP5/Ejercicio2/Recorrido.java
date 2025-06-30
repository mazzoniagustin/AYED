package TP5.Ejercicio2;

import TP5.Graph;
import TP5.Vertex;
import TP5.Edge;
import TP5.adjList.*;
import TP2.Queue;
import java.util.*;


public class Recorrido {
	
	public Recorrido() {
		
	}

	public List<T> dfs (Graph<T> grafo) {
	
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> list = new LinkedList<T>();
	
		for (int i = 0 ; i < grafo.getSize() ; i++) {
			if (!marca[i]) {
				dfsHelper(i,grafo,list,marca);
			}
	
		}

	}
	
	
	private void dfsHelper(int pos, Graph<T> grafo, List<T> lista, boolean[] marca) {
		marca[pos] = true;
		Vertex<T> v = grafo.getVertex();
		lista.add(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> ad : adyacentes) {
			int j = ad.getTarget().getPosition();
			if (!marca[j]) {
				dfsHelper(j,grafo,lista,marca);
			}
		}
	}
	
	public List<T> bfs(Graph<T> grafo) {
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> datos = new LinkedList<T>();
		for (int i = 0 ; i < grafo.getSize() ; i++) {
			if (!marca[i]) {
				bfsHelper(i,grafo,datos,marca);
			}
		}
		return datos;
	}
	
	
	private void bfsHelper(int i,Graph<T> grafo,List<T> lista, boolean[] marca) {
		Queue<Vertex<T>> cola = new Queue<Vetex<T>>();
		cola.enqueue(grafo.getVertex(i));
		marca[i] = true;
		while (!cola.isEmpty()) {
			Vertex<T> w = cola.dequeue();
			lista.add(w.getData());
			List<Edge<T>> adyacentes = grafo.getEdges();
			for (Edge<T> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					cola.enqueue(e.getTarget());
				}
			}
			
		}
		
		
	}
	
	
	private void bfshelper
	

}