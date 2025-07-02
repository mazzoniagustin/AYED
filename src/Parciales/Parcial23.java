package Parciales;
import TP2.BinaryTree;

public class Parcial23 {
	private BinaryTree<Integer> ab;
	
	public Parcial23(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> nuevoTree() {
		BinaryTree<Integer> nuevoAb = new BinaryTree<Integer>();
		
		if (!ab.isEmpty()) {
			nuevoTreeHelper(ab,nuevoAb,0);
		}
		
		return nuevoAb;
	}
	
	private static void nuevoTreeHelper(BinaryTree<Integer> ab, BinaryTree<Integer> nuevoAb, int valorPadre) {
		int valor = ab.getData() + valorPadre;
		nuevoAb.setData(valor);
		
		if (ab.hasLeftChild()) {
			nuevoAb.addLeftChild(new BinaryTree<Integer>());
			nuevoTreeHelper(ab.getLeftChild(),nuevoAb.getLeftChild(),valor);
		}
		
		if (ab.hasRightChild()) {
			nuevoAb.addRightChild(new BinaryTree<Integer>());
			nuevoTreeHelper(ab.getRightChild(),nuevoAb.getRightChild(),0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
