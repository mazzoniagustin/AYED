package Parciales;
import TP3.GeneralTree;
import java.util.*;
import TP2.Queue;


public class Adicional5 {
	private GeneralTree<Integer> arbol;
	
	public List<Integer> camino(int num) {
		List<Integer> camAct = new LinkedList<Integer>();
		boolean ok = false;
 		if (!arbol.isEmpty()) {
			ok = caminoHelper(arbol,camAct,,num);
		}
 		return ok;
	}
	
	private static boolean caminoHelper(GeneralTree<Integer> arbol, List<Integer> camAct, int num) {
		
		camAct.add(arbol.getData());
		
		if (arbol.isLeaf()) {
			return true;
		}
		
		if (arbol.getChildren().size() < num) {
			camAct.remove(camAct.size() - 1);
			return false;
		}
		
		
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			if (caminoHelper(child,camAct,num)) {
				return true;
			}
		}
		
		camAct.remove(camAct.size() - 1);
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
