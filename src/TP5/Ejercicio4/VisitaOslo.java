package TP5.Ejercicio4;
import TP5.*;
import java.util.*;

public class VisitaOslo {
	private Graph<String> lugares;
	
	public VisitaOslo(Graph<String> lugares) {
		this.lugares = lugares;
	}
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		List<String> camino = new LinkedList<String>();
		if (lugares != null) {
			boolean[] marcas = new boolean[lugares.getSize()];
			Vertex<String> origen = lugares.search("Ayuntamiento");
			Vertex<String> des = lugares.search(destino);
			if (origen != null && destino != null) {
				for (String restringido : lugaresRestringidos) {
					Vertex<String> v = lugares.search(restringido);
					if (v != null) {
						marcas[v.getPosition()] = true;
					}
				}
				paseoEnBiciHelper(lugares,origen,des,maxTiempo,camino,marcas);
			}
		}
		return camino;
	}
	
	private boolean paseoEnBiciHelper(Graph<String> lugares, Vertex<String> origen, Vertex<String> destino, int tiempoMax, List<String> camino, boolean[] marcas) {
		marcas[origen.getPosition()] = true;
		camino.add(origen.getData());
		boolean ok = false;
		if (origen == destino) {
			return true;
		}
		else {
			for (Edge<String> ad : lugares.getEdges(origen)) {
				int pos = ad.getTarget().getPosition();
				int tiempo = ad.getWeight();
				if ((!marcas[pos]) && (tiempoMax - tiempo >= 0) && (!ok)) {
					ok = paseoEnBiciHelper(lugares,ad.getTarget(),destino,tiempoMax-tiempo,camino,marcas);
				}
			}
		}
		if (!ok) {
			camino.remove(camino.size()-1);
		}
		marcas[origen.getPosition()] = false;
		return ok;
	}
	
	

}
