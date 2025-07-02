package TP5.Parciales.Parcial2;
import TP5.*;
import java.util.*;

public class Parcial {
	private Graph<Recinto> grafo;
	
	public Parcial (Graph<Recinto> grafo) {
		this.grafo = grafo;
	}
	
	public int resolver(Graph<Recinto> sitio, int tiempo) {
		int cant = 0;
		if (!sitio.isEmpty()) {
			boolean[] visitados = new boolean[sitio.getSize()];
			Vertex<Recinto> origen = buscarSitio(sitio,"Entrada");
			if (origen != null) {
				if (origen.getData().getMinutos() <= tiempo) {
					resolverHelper(sitio,origen,tiempo-origen.getData().getMinutos(),visitados,cant+1,-1);
				}
				
			}
		}
		return cant;
	}
	
	
	private Vertex<Recinto> buscarSitio(Graph<Recinto> sitio, String nombre) {
		List<Vertex<Recinto>> vertices = sitio.getVertices();
		Iterator<Vertex<Recinto>> it = vertices.iterator();
		Vertex<Recinto> sit = null;
		boolean encontre = false;
		while (it.hasNext() && !encontre) {
			Vertex<Recinto> aux = it.next();
			if (aux.getData().getNombre().equals("Entrada")) {
				sit = aux;
				encontre = true;
			}
		}
		return sit;
		
	}
	
	private int resolverHelper(Graph<Recinto> sitio, Vertex<Recinto> origen, int tiempo, boolean[] visitados, int cant, int max) {
		visitados[origen.getPosition()] = true;
		for (Edge<Recinto> ad : sitio.getEdges(origen)) {
			Vertex<Recinto> destino = ad.getTarget();
			int pos = destino.getPosition();
			int peso = ad.getWeight() + destino.getData().getMinutos();
			if (!visitados[pos] && peso <= tiempo) {
				int nuevoMax = resolverHelper(sitio,destino,tiempo-peso,visitados,cant+1,max);
				if (nuevoMax > max) {
					max = nuevoMax;
				}
			}
		}
		visitados[origen.getPosition()] = false;
		if (cant > max) {
			max = cant;
		}
		return max;
	}

}
