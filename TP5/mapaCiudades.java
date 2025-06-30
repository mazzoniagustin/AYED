package TP5;
import TP5.Graph;
import TP5.Edge;
import TP5.Vertex;
import TP5.adjList.*;
import java.util.*;

public class mapaCiudades {
	private Graph<String> grafo;
	
	public mapaCiudades(Graph<String> grafo) {
		this.grafo = grafo;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> camino = new LinkedList<String>();
		boolean[] marcas = new boolean[grafo.getSize()];
		Vertex<String> origen = grafo.search(ciudad1);
		Vertex<String> destino = grafo.search(ciudad2);
		if ((origen != null) && (destino != null) {
			devolverCaminoHelper(origen,destino,camino,marcas);
		}
		return camino;
		
	}
	
	private boolean devolverCaminoHelper(Vertex<String> origen , Vertex<String> destino, List<String> camino, boolean[] marcas) {
		boolean ok = false;
		marcas[origen.getPosition()] = true;
		camino.add(origen.getData());
		if (origen == destino) {
			ok = true;
		}
		else {
			List<Edge<String>> adyacentes = grafo.getEdges(origen);
			for (Edge<String> e : adyacentes) {
				if (!marcas[e.getTarget().getPosition()] && (!ok)) {
					ok = devolverCaminoHelper(e.getTarget(),destino,camino,marcas);
				}
			}
			if (!ok) {
				camino.remove(camino.size()-1);
			}
			else {
				ok = true;
			}
		}
		return ok;
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
		List<String> caminoAct = new LinkedList<String>();
		boolean[] marcas = new boolean[grafo.getSize()];
		Vertex<String> origen = grafo.search(ciudad1);
		Vertex<String> destino = grafo.search(ciudad2);
		if (origen != null && destino != null) {
			devolverCaminoExceptuandoHelper(origen,destino,caminoAct,marcas,ciudades);
		}
		return caminoAct;
	}
	
	private boolean devolverCaminoExceptuandoHelper(Vertex<String> origen, Vertex<String> destino, List<String> lista, boolean[] marcas, List<String> ciudades) {
		boolean ok = false;
		marcas[origen.getPosition()] = true;
		lista.add(origen.getData());
		if (origen == destino) {
			ok = true;
		}
		else {
			int pos;
			String lugar;
			List<Edge<String>> adyacentes = grafo.getEdges(origen);
			for (Edge<String> ad : adyacentes) {
				pos = ad.getTarget().getPosition();
				lugar = ad.getTarget().getData();
				if (ciudades.contains(lugar)) {
					marcas[pos] = true;
				}
				if (!marcas[pos] && !ok) {
					ok = devolverCaminoExceptuandoHelper(ad.getTarget(),destino,lista,marcas,ciudades);
				}
			}
			
		if (!ok) {
			lista.remove(lista.size()-1);
			marcas[origen.getPosition()] = false;
			}
		else {
			ok = true;
		}
	}
	return ok;

	}
	
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		boolean[] marcas = new boolean[grafo.getSize()];
		List<String> camAct = new LinkedList<String>();
		List<String> camMin = new LinkedList<String>();
		Vertex<String> origen = grafo.search(ciudad1);
		Vertex<String> destino = grafo.search(ciudad2);
		if (origen != null && destino != null) {
			caminoMasCortoHelper(origen,destino,marcas,camAct,camMin,0,999);
		}
		return camMin;
	}
	
	private int caminoMasCortoHelper(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> caminoAct, List<String> caminoMin, int min, int minTotal) {
		marcas[origen.getPosition()] = true;
		caminoAct.add(origen.getData());
		if (origen == destino) {
			if (min < minTotal) {
				caminoMin.removeAll(caminoMin);
				caminoMin.addAll(caminoAct);
				minTotal = min;
			}
		}
		else {
			for (Edge<String> ad : grafo.getEdges(origen)) {
				int pos = ad.getTarget().getPosition();
				int distancia = min + ad.getWeight();
				
				if (!marcas[pos] && distancia < minTotal) {
					int nuevoMinTotal = caminoMasCortoHelper(ad.getTarget(),destino,marcas,caminoAct,caminoMin,distancia,minTotal);
					if (nuevoMinTotal < minTotal) {
						minTotal = nuevoMinTotal;
					}
				}
				
			}
		}
		caminoAct.remove(caminoAct.size()-1);
		marcas[origen.getPosition()] = false;
		return minTotal;
	}
	
	public List<String> caminoSinCargar(String ciudad1, String ciudad2, int tanqueAuto) {
		boolean[] marcas = new boolean[grafo.getSize()];
		List<String> camino = new LinkedList<String>();
		Vertex<String> origen = grafo.search(ciudad1);
		Vertex<String> destino = grafo.search(ciudad2);
		if (origen != null && destino != null) {
			caminoSinCargarHelper(origen,destino,marcas,tanqueAuto,camino);
		}
		return camino;
	}
	
	private boolean caminoSinCargarHelper(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, int tanqueAuto, List<String> camino) {
		boolean ok = false;
		marcas[origen.getPosition()] = true;
		camino.add(origen.getData());
		if (origen == destino) {
			return true;
		}
		else {
			for (Edge<String> ad : grafo.getEdges(origen)) {
				int pos = ad.getTarget().getPosition();
				int comb = ad.getWeight();
				
				if (!marcas[pos] && tanqueAuto - comb > 0 && !ok) {
					ok = caminoSinCargarHelper(ad.getTarget(),destino,marcas,(tanqueAuto-comb),camino);
				}
			}
		}
		if (!ok) {
			camino.remove(camino.size()-1);
		}
		marcas[origen.getPosition()] = false;
		return ok;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
