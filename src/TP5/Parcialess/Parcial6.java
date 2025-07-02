package TP5.Parcialess;
import TP5.*;
import java.util.*;

public class Parcial6 {
	private Graph<String> grafo;
	
	public Parcial6(Graph<String> grafo) {
		this.grafo = grafo;
	}
	
	public List<String> buscadorCamino (Graph<String> grafo , String origen, String destino, int montoMax) {
		List<String> camino = new LinkedList<String>();
		if (grafo != null && !grafo.isEmpty()) {
			Vertex<String> or = grafo.search(origen);
			Vertex<String> des = grafo.search(destino);
			boolean[] visitados = new boolean[grafo.getSize()];
			if (or != null && des != null) {
				buscadorCaminoHelper(grafo,or,des,montoMax,camino,visitados);
				}
			}
		return camino;
	}
	
	private boolean buscadorCaminoHelper(Graph<String> grafo, Vertex<String> origen , Vertex<String> destino, int montoMax, List<String> camino, boolean[] visitados) {
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		boolean encontre = false;
		if (origen == destino) {
			return true;
		}
		else {
			Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
			while (it.hasNext() && !encontre) {
				Edge<String> aux = it.next();
				Vertex<String> dest = aux.getTarget();
				int pos = dest.getPosition();
				int costo = aux.getWeight();
				if (!visitados[pos] && montoMax - costo >= 0) {
					encontre = buscadorCaminoHelper(grafo,dest,destino,montoMax-costo,camino,visitados);
				}
			}
		}
		if (!encontre) {
			camino.remove(camino.size()-1);
		}
		visitados[origen.getPosition()] = false;
		return encontre;
	}
	
	
}


