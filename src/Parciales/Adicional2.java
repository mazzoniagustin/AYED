package Parciales;
import TP2.BinaryTree;

public class Adicional2 {
	private BinaryTree<Integer> arbol;
	
	public Adicional2(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok = false;
		if ((!arbol1.isEmpty()) && (!arbol2.isEmpty())) {
			ok = esPrefijoHelper(arbol1, arbol2);
		}
		else {
			if (arbol1.isEmpty() && arbol2.isEmpty()) {
				ok = true;
			}
		}
		return ok;
	}
	
	private boolean esPrefijoHelper(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1.getData() != arbol2.getData()) {
			return false;
		}
		boolean res = true;
		if (arbol1.hasLeftChild()) {
			if (arbol2.hasLeftChild()) {
				res = res && esPrefijoHelper(arbol1.getLeftChild(),arbol2.getLeftChild());
			}
			else {
				return false;
			}
		}
		if (arbol1.hasRightChild()) {
			if (arbol2.hasRightChild()) {
				res = res && esPrefijoHelper(arbol1.getRightChild(),arbol2.getRightChild());
			}
			else {
				return false;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
