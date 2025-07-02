package TP5.Parciales.Parcial1;
import java.util.List;
import java.util.*;

import TP5.*;

public class parcial {
	private Graph<Ciudad> mapa;
	
	public parcial(Graph<Ciudad> grafo) {
		this.mapa = grafo;
	}
	
	
	public List<String> resolver (Graph<Ciudad> grafo , String nombreCiudad, int cantDias) {
		List<String> lista = new LinkedList<String>();
		if (!grafo.isEmpty()) {
			boolean[] visitados = new boolean[grafo.getSize()];
			Vertex<Ciudad> origen = buscarCiudad(grafo,nombreCiudad);
			List<String> caminoMax = new LinkedList<String>();
			if (origen != null) {
				if (origen.getData().getDias() <= cantDias) {
					resolverHelper(grafo,origen,cantDias-origen.getData().getDias(),lista, caminoMax,visitados);
				}
			}
		}
		return lista;
	}

	private void resolverHelper(Graph<Ciudad> grafo, Vertex<Ciudad> origen, int cantDias, List<String> camino, List<String> caminoMax, boolean[] visitados) {
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData().getNombre());
		if (cantDias == 0) {
			if (camino.size() > caminoMax.size()) {
				caminoMax.removeAll(caminoMax);
				caminoMax.addAll(camino);
			}
		}
		else {
			for (Edge<Ciudad> ad : grafo.getEdges(origen)) {
				int pos = ad.getTarget().getPosition();
				int dias = ad.getTarget().getData().getDias();
				if (!visitados[pos] && dias <= cantDias) {
					resolverHelper(grafo,ad.getTarget(),cantDias-dias,camino,caminoMax,visitados);
				}
			}
		}
		camino.remove(camino.size()-1);
		visitados[origen.getPosition()] = false;
	}
	
	
	
	
	
	private Vertex<Ciudad> buscarCiudad(Graph<Ciudad> grafo, String nombre) {
		Vertex<Ciudad> origen = null;
		List<Vertex<Ciudad>> vertices = grafo.getVertices();
		Iterator<Vertex<Ciudad>> it = vertices.iterator();
		boolean sigo = false;
		while (it.hasNext() && !sigo) {
			Vertex<Ciudad> aux = it.next();
			if (aux.getData().getNombre().equals(nombre)) {
				sigo = true;
				origen = aux;
			}
		}
		return origen;
	}
}
