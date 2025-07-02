package Parciales;
import TP3.GeneralTree;
import java.util.*;

public class Parcial15 {
	private GeneralTree<Integer> arbol;
	
	public Parcial15 (GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<GeneralTree<Integer>> resolver(GeneralTree<Integer> arbol) {
		List<GeneralTree<Integer>> lista = new LinkedList<GeneralTree<Integer>>();
		if (!arbol.isEmpty() && (arbol != null)) {
			resolverHelper(arbol,lista);
		}
		return lista;
	}
	s
	private static void resolverHelper(GeneralTree<Integer> arbol , List<GeneralTree<Integer>> lista) {
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		if (arbol.hasChildren()) {
			resolverHelper(children.get(0),lista);
		}
		if (arbol.hasChildren() && (children.size() % 2 == 0)) {
			lista.add(arbol);
		}
		for (int i = 1 ; i < children.size() ; i++) {
			if (!children.get(i).isLeaf()) {
				resolverHelper(children.get(i),lista);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
