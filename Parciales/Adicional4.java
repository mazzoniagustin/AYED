package Parciales;
import TP3.GeneralTree;
import java.util.*;

public class Adicional4 {
	GeneralTree<Integer> arbol;
	
	public Adicional4(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if (!arbol.isEmpty()) {
			return esDeSeleccionHelper(arbol);
		}
		else {
			return false;
		}
	}
	
	private static boolean esDeSeleccionHelper(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) {
			return true;
		}
		int min = 9999;
		boolean ok = true;
		List<GeneralTree<Integer>> children = arbol.getChildren();
		
		for (GeneralTree<Integer> child : children) {
			if (!esDeSeleccionHelper(child)) {
				ok = false;
			}
			if (child.getData() < min) {
				min = child.getData();
			}
		}
		if (ok && min == arbol.getData()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
