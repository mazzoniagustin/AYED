package Parciales;
import java.util.*;
import TP3.GeneralTree;
import TP2.Queue;

public class Parcial15_6 {
	private GeneralTree<Integer> arbol;
	
	public Parcial15_6(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> nivel(int num) {
		List<Integer> lista = new LinkedList<Integer>();
		if ((!arbol.isEmpty()) && (arbol != null)) {
			nivelHelper(arbol,num,lista);
		}
		return lista;
	}
	
	private static void nivelHelper(GeneralTree<Integer> arbol , int num , List<Integer> lista) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		int nivelAct = 0;
		
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		boolean ok = false;
		
		while (!ok && !cola.isEmpty()) {
			aux = cola.dequeue();
			
			if (aux != null) {
				if (nivelAct == num) {
					lista.add(aux.getData());
				}
			}
			else {
				if (!cola.isEmpty()) {
					for (GeneralTree<Integer> child : aux.getChildren());
				}
				nivelAct++;
			}
			if (lista.size() > 1) {
				ok = true;

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
