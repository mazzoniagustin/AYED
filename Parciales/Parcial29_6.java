package Parciales;
import TP2.BinaryTree;
public class Parcial29_6 {
	private BinaryTree<Integer> ab;
	
	public Parcial29_6 (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> nuevoTree() {
		if (!ab.isEmpty()) {
			BinaryTree<Integer> nuevoAb = new BinaryTree<Integer>();
			nuevoTreeHelper(ab,nuevoAb,0);
			return nuevoAb;
		}
		else {
			return null;
		}
	}
	
	private static void nuevoTreeHelper(BinaryTree<Integer> ab , BinaryTree<Integer> nuevoAb , int valorPadre) {
		int valor = ab.getData() + valorPadre;
		nuevoAb.setData(valor);
		if (ab.hasLeftChild()) {
			BinaryTree<Integer> leftC = new BinaryTree<Integer>();
			nuevoAb.addLeftChild(leftC);
			nuevoTreeHelper(ab.getLeftChild(),leftC,valor);
		}
		if (ab.hasRightChild() ) {
			BinaryTree<Integer> RightC = new BinaryTree<Integer>();
			nuevoAb.addRightChild(RightC);
			nuevoTreeHelper(ab.getRightChild(),RightC,valor);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
