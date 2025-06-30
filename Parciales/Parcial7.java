package Parciales;
import TP3.GeneralTree;
import java.util.*;
public class Parcial7 {
	private GeneralTree<Character> ab;
	
	public Parcial7 (GeneralTree<Character> ab) {
		this.ab = ab;
	}
	
	public List<List<Character>> caminosPares(GeneralTree<Character> ab) {
		if (!ab.isEmpty()) {
			List<Character> camAct = new LinkedList<>();
			List<List<Character>> caminos = new LinkedList<>();
			caminosParesHelper(ab,caminos,camAct,0);
			return caminos;
		}
		else {
			return null;
		}
	}
	
	private void caminosParesHelper(GeneralTree<Character> ab, List<List<Character>> caminos, List<Character> camAct, int cant) {
		cant++;
		camAct.add(ab.getData());
		
		if (ab.isLeaf()) {
			if (cant % 2 == 0) {
				caminos.add(new LinkedList<>(camAct));
			}
		}
		else {
			for (GeneralTree<Character> child : ab.getChildren()) {
				caminosParesHelper(child,caminos,camAct,cant);
			}
		}
		camAct.remove(camAct.size() - 1);
	}

	public static void main(String[] args) {
		Parcial7 ab = new Parcial7()

	}

}
