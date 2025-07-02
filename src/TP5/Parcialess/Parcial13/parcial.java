package TP5.Parcialess.Parcial13;
import java.util.*;
import TP5.*;
import TP2.Queue;

public class parcial {
	private Graph<String> grafo;
	
	public parcial(Graph<String> grafo) {
		this.grafo = grafo;
	}
	
	public Objeto resolver(Graph<String> grafo, String usuario, int distancia, int umbral) {
		Objeto obj = null;
		if (!grafo.isEmpty() && grafo != null) {
			Vertex<String> origen = grafo.search(usuario);
			if (origen != null) {
				boolean[] visitados = new boolean[grafo.getSize()];
				resolverHelper(grafo,origen,distancia,visitados,obj);
				if (obj.getCantidad() == 0) {
					obj.setCantidad(0);
					obj.setPopular(false);
				}
				else {
					obj.esPopular(umbral);
				}
			}
		}
		return obj;
	}
	
	
	private void resolverHelper(Graph<String> grafo, Vertex<String> origen, int distancia, boolean[] visitados, Objeto obj) {
	    int distanciaAct = 0;
	    Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
	    cola.enqueue(origen);
	    cola.enqueue(null); // marcador de nivel
	    visitados[origen.getPosition()] = true;

	    while (!cola.isEmpty() && distanciaAct <= distancia) {
	        Vertex<String> actual = cola.dequeue();

	        if (actual != null) {
	            for (Edge<String> ady : grafo.getEdges(actual)) {
	                Vertex<String> vecino = ady.getTarget();
	                int pos = vecino.getPosition();

	                if (!visitados[pos]) {
	                    visitados[pos] = true;
	                    cola.enqueue(vecino);
	                    
	                    if (distanciaAct < distancia) {
	                        obj.aumentarCant(); // sumar si estamos en distancia válida
	                    }
	                }
	            }
	        } else {
	            if (!cola.isEmpty()) {
	                cola.enqueue(null);
	                distanciaAct++;
	            }
	        }
	    }
}
}