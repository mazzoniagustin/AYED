package Parciales;
import TP2.BinaryTree;

public class Parcial1 {
	BinaryTree<Integer> ab;
	
	public Parcial1 (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public Boolean isTwoTree(int num) {
		if (!ab.isEmpty()) {
			BinaryTree<Integer> subAb = buscar(ab,num);
			if (subAb != null) {
				return (isTwoTreeHelper(subAb,num));
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num) {
		if (ab.getData() == num) {
			return ab;
		}
		else {
			BinaryTree<Integer> res = new BinaryTree<Integer>();
			if (ab.hasLeftChild()) {
				res = buscar(ab.getLeftChild(),num);
			}
			if ((ab.hasRightChild()) && (res == null)) {
				res = buscar(ab.getRightChild(),num);
			}
			return res;
		}
	}
	
	private boolean isTwoTreeHelper(BinaryTree<Integer> ab, int num) {
		int hijoI = -1;
		int hijoD = -1;
		
		if (ab.hasLeftChild()) {
			hijoI = contarHijos(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			hijoD = contarHijos(ab.getRightChild());
		}
		return hijoI == hijoD;
		
	}
	
	private int contarHijos(BinaryTree<Integer> ab) {
		int cant = 0;
		
		if (ab.hasLeftChild()) {
			cant += contarHijos(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			cant += contarHijos(ab.getRightChild());
		}
		if (ab.hasLeftChild() && ab.hasRightChild()) {
			cant++;
		}
		
		return cant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
