package Parciales.Parcial6Princesa;
import TP2.BinaryTree;
import java.util.*;
public class Parcial6 {
	private BinaryTree<Personaje> ab;
	
	public Parcial6(BinaryTree<Personaje> ab) {
		this.ab = ab;
	}
	
	public List<Personaje> princesaAccesible() {
		if (!ab.isEmpty()) {
			List<Personaje> caminoMax = new LinkedList<Personaje>();
			List<Personaje> caminoAct = new LinkedList<Personaje>();
			princesaAccesibleHelper(ab,caminoAct,caminoMax);
			return caminoMax;
		}
		else {
			return null;
		}
	}
	
	private void princesaAccesibleHelper(BinaryTree<Personaje> ab, List<Personaje> camAct, List<Personaje> camMax) {
		
		if (!ab.getData().esDragon()) {
			camAct.add(ab.getData());
		}
		
		if (ab.getData().esPrincesa()) {
			if (camAct.size() > camMax.size()) {
				camMax.clear();
				camMax.addAll(camAct);
			}
		}
		if (ab.hasLeftChild()) {
			princesaAccesibleHelper(ab.getLeftChild(),camAct,camMax);
		}
		
		if (ab.hasRightChild()) {
			princesaAccesibleHelper(ab.getRightChild(),camAct,camMax);
		}
		camAct.remove(camAct.size() - 1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
