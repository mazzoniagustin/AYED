package Parciales;
import TP2.BinaryTree;

public class Parcial9 {
	private BinaryTree<Integer> ab;
	
	public Parcial9 (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public static int sumaImparesPosOrdenMayorA(BinaryTree<Integer> ab, int num) {
		if (!ab.isEmpty() && (ab != null)) {
			return sumaImparesPosOrdenMayorAHelper(ab, num);
		}
		else {
			return 0;
		}
	}
	
	private static int sumaImparesPosOrdenMayorAHelper(BinaryTree<Integer> ab, int limite) {
		int suma = 0;
		
		if (ab.hasLeftChild()) {
			suma += sumaImparesPosOrdenMayorAHelper(ab.getLeftChild(),limite);
		}
		if (ab.hasRightChild()) {
			suma += sumaImparesPosOrdenMayorAHelper(ab.getRightChild(),limite);
		}
		if ((ab.getData() % 2 != 0) && (ab.getData() > limite)) {
			suma += ab.getData();
		}
		return suma;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
