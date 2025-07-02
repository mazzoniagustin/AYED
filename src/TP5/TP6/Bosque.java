package TP5.TP6;
import TP5.*;
import java.util.*;

public class Bosque {
	private Graph<String> grafo;
	
	public Bosque(Graph<String> grafo) {
		this.grafo = grafo;
	}
	
	
	
	public List<List<String>> recorridoMasSeguro() {
		List<List<String>> caminos = new LinkedList<List<String>>();
		List<String> camAct = new LinkedList<String>();
		if (!grafo.isEmpty()) {
			Vertex<String> origen = grafo.search("Casa Caperucita");
			Vertex<String> destino = grafo.search("Casa Abuelita");
			boolean[] marcas = new boolean[grafo.getSize()];
			if (origen != null && destino != null) {
				recorridoHelper(grafo,origen,destino,marcas,camAct,caminos);
			}
		}
		return caminos;
	}
	
	public void recorridoHelper(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> camAct, List<List<String>> caminos) {
		marcas[origen.getPosition()] = true;
		camAct.add(origen.getData());
		if (origen == destino) {
			caminos.add(new LinkedList<>(camAct));
		}
		else {
			for (Edge<String> ad : grafo.getEdges(origen)) {
				int peso = ad.getWeight();
				int pos = ad.getTarget().getPosition();
				if (!marcas[pos] && peso < 5) {
					recorridoHelper(grafo,ad.getTarget(),destino,marcas,camAct,caminos);
				}
			}
		}
		marcas[origen.getPosition()] = false;
		camAct.remove(camAct.size()-1);
	}

}
