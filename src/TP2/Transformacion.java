package TP2;
import TP2.BinaryTree;
public class Transformacion {
	private BinaryTree <Integer> ab;
	
	public Transformacion (BinaryTree <Integer> unAb) {
		this.ab = unAb;
	}
	
	public BinaryTree<Integer> suma() {
		if (!ab.isEmpty()) {
			sumaElementos(ab);
			return ab;
		}
		else {
			return null;
		}
	}
	
	private int sumaElementos(BinaryTree<Integer> ab) {
		int sum = 0;
		if (ab.isLeaf()) {
			sum = ab.getData();
			ab.setData(0);
			return sum;
		}
		if (ab.hasLeftChild() ) {
			sum += sumaElementos(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			sum += sumaElementos(ab.getRightChild());
		}
		int act = ab.getData();
		ab.setData(sum);
		return sum + act;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
