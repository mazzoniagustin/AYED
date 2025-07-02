package TP5.Parcialess.Parcial12;
import TP5.*;
import java.util.*;


public class parcial {
	private Graph<Ciudad> grafo;
	
	public parcial (Graph<Ciudad> grafo) {
		this.grafo = grafo;
	}
	
	public int resolver (Graph<Ciudad> grafo , String origen, String destino, int maxControles) {
		int max = 0;
		if (!grafo.isEmpty() && grafo != null) {
			Vertex<Ciudad> or = buscarVertice(grafo,origen);
			Vertex<Ciudad> des = buscarVertice(grafo,destino);
			if (or != null && des != null) {
				boolean[] visitados = new boolean[grafo.getSize()];
				max = resolverHelper(grafo,or,des,maxControles, visitados, or.getData().getDias(), 0);
			}
		}
		return max;
	}
	
	private int resolverHelper(Graph<Ciudad> grafo, Vertex<Ciudad> origen, Vertex<Ciudad> destino, int maxControles, boolean[] visitados, int diasAct, int diasMax) {
		visitados[origen.getPosition()] = true;
		if (origen == destino) {
			if (diasAct > diasMax) {
				diasMax = diasAct;
			}
		}
		else {
			for (Edge<Ciudad> ady : grafo.getEdges(origen)) {
				Vertex<Ciudad> dest = ady.getTarget();
				int pos = dest.getPosition();
				int controles = ady.getWeight();
				if (!visitados[pos] && controles <= maxControles) {
					diasMax = resolverHelper(grafo,dest,destino,maxControles,visitados,diasAct + dest.getData().getDias(), diasMax);
				}
			}
		}
		visitados[origen.getPosition()] = false;
		return diasMax;
	}
	
	
	
	private Vertex<Ciudad> buscarVertice(Graph<Ciudad> grafo, String ciudad) {
		Vertex<Ciudad> lugar = null;
		Iterator<Vertex<Ciudad>> it = grafo.getVertices().iterator();
		boolean encontre = false;
		while (it.hasNext() && !encontre) {
			Vertex<Ciudad> aux = it.next();
			if (aux.getData().getNombre().equals(ciudad)) {
				encontre = true;
				lugar = aux;
			}
		}
		return lugar;
	}

}
