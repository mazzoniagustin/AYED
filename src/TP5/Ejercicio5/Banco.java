package TP5.Ejercicio5;
import TP5.*;
import java.util.*;
import TP2.Queue;

public class Banco {
	private Graph<Persona> banco;
	
	public Banco(Graph<Persona> banco) {
		this.banco = banco;
	}
	
	public List<Jubilado> quedateEnCasa(Graph<Persona> grafo , int grado, String empleado) {
		List<Jubilado> lista = new LinkedList<Jubilado>();
		Vertex<Persona> emp = buscarEmpleado(grafo,empleado);
		if (emp != null) {
			boolean[] marcas = new boolean[grafo.getSize()];
			quedateEnCasaHelper(grafo,emp,grado,marcas,lista);
		}
		return lista;
		
	}
	
	private List<Jubilado> quedateEnCasaHelper(Graph<Persona> grafo, Vertex<Persona> empleado, int grado,boolean[] marcas, List<Jubilado> lista) {
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		marcas[empleado.getPosition()] = true;
		cola.enqueue(empleado);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			Vertex<Persona> aux = cola.dequeue();
			if (aux != null) {
				List<Edge<Persona>> ad = grafo.getEdges(aux);
				Iterator<Edge<Persona>> it = ad.iterator();
				while (it.hasNext() && grado > 0 && lista.size() < 40) {
					Vertex<Persona> destino = it.next().getTarget();
					int pos = destino.getPosition();
					if (!marcas[pos]) {
						marcas[pos] = true;
						cola.enqueue(destino);
						if (destino.getData().cumple()) {
							lista.add(new Jubilado(destino.getData().getNombre(), destino.getData().getDomicilio()));
						}
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					grado--;
					cola.enqueue(null);
				}
			}
		}
		return lista;
	}
	
	
	
	
	private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String empleado) {
		List<Vertex<Persona>> vertices = grafo.getVertices();
		Iterator<Vertex<Persona>> it = vertices.iterator();
		Vertex<Persona> persona = null;
		boolean encontre = false;
		while (it.hasNext() && !encontre) {
			Vertex<Persona>aux = it.next();
			if (aux.getData().getNombre().equals(empleado)) {
				encontre = true;
				persona = aux;
			}
		}
		return persona;
	}

}
