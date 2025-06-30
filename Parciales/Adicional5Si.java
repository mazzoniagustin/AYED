package Parciales;
import TP3.GeneralTree;
import java.util.*;


public class Adicional5Si {
	private GeneralTree<Integer> arbol;
	
	public Adicional5Si (GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> camino = new LinkedList<Integer>();
		List<Integer> caminoMax = new LinkedList<Integer>()
		if (!arbol.isEmpty()) {
			resolverHelper(arbol,camino, caminoMax,0,0,-999);
		}
		return caminoMax;
	}
	
	private static void resolverHelper(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoMax, int nivel,int suma, int max) {
		if (arbol.getData() == 1) {
			caminoAct.add(arbol.getData());
			suma+= arbol.getData() * nivel;
		}
		
		if (!arbol.isLeaf()) {
			for (GeneralTree<Integer> child : arbol.getChildren()) {
				resolverHelper(child,caminoAct,caminoMax,nivel+1,suma,max);
			}
		}
		if (suma > max) {
			max = suma;
			caminoMax.removeAll(caminoMax);
			caminoMax.addAll(caminoAct);
		}
		caminoAct.remove(caminoAct.size()-1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
