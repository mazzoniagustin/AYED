package Parciales;
import TP3.GeneralTree;
import java.util.*;

public class Parcial10 {
	private GeneralTree<Integer> ag;
	
	public Parcial10 (GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	public static List<Integer> caminoMasLejano(GeneralTree<Integer> ag) {
		List<Integer> caminoAct = new LinkedList<Integer>();
		List<Integer> caminoMax = new LinkedList<Integer>();
		if (!ag.isEmpty()) {
			caminoMasLejanoHelper(ag,caminoAct,caminoMax);
		}
		return caminoMax;
	}
	
	private static void caminoMasLejanoHelper(GeneralTree<Integer> ag, List<Integer> camAct, List<Integer> camMax) {
		camAct.add(ag.getData());
		
		if (ag.isLeaf()) {
			if (camAct.size() > camMax.size()) {
				camMax.clear();
				camMax.addAll(camAct);
			}
		}
		else {
			for (GeneralTree<Integer> child : ag.getChildren()) {
				caminoMasLejanoHelper(child,camAct,camMax);
			}
		}
		camAct.remove(camAct.size()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
