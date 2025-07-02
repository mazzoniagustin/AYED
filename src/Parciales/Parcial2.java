package Parciales;
import TP2.BinaryTree;

public class Parcial2 {	
	private BinaryTree<Integer> ab;
	
	public Parcial2 (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public boolean resolver(int k) {
		if (!ab.isEmpty()) {
			return resolverHelper(ab,k,0);
		}
		else {
			return false;
		}
	}
	
	private static boolean resolverHelper(BinaryTree<Integer> ab , int k , int suma) {
		suma += ab.getData();
		
		if (ab.isLeaf()) {
			return k == suma;
		}
		
		else {
			boolean izq = true;
			boolean der = true;
			if (ab.hasLeftChild()) {
				izq = resolverHelper(ab.getLeftChild(),k,suma);
			}
			if (ab.hasRightChild()) {
				der = resolverHelper(ab.getRightChild(),k,suma);
			}
			
		return (izq && der);
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
