package TP3;
import java.util.*;
public class ej10 {
	
	public List<Integer> resolver(GeneralTree<Integer> arbol) {
		
	}
	
	private void resolverHelper(GeneralTree<Integer> arbol, List<Integer> caminoAct, int nivel, int sumaAct, int max) {
		
		boolean encontre = false;
		
		if (arbol.getData() == 1) {
			caminoAct.add(arbol.getData());
		}
		
		sumaAct += arbol.getData() * nivel;
		
		if (arbol.isLeaf()) {
			if (sumaAct < max) {
				caminoAct.clear();
			}
			else {
				encontre = true;
			}
		}
		else {
			Iterator<GeneralTree<Integer>> it = new GeneralTree<Integer>();
			while (!encontre &&)
		}
		
		
	}

}
