package TP2;
import TP2.BinaryTree;

public class RedBinaria {
	private BinaryTree <Integer> ab;
	
	public RedBinaria (BinaryTree<Integer> unAb) {
		this.ab = unAb;
	}
	
	public int retardoEnvio (BinaryTree<Integer> ab) {
		if (!ab.isEmpty()) {
			return calcularRetardo(ab);
		}
		else {
			return 0;
		}
	}
	
	private int calcularRetardo (BinaryTree<Integer> ab) {
		int leftC = 0;
		int rightC = 0;
		
		if (ab.hasLeftChild()) {
			leftC = calcularRetardo(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			rightC = calcularRetardo(ab.getRightChild());
		}
		return (Math.max(leftC, rightC) + ab.getData());
		
	}

	public static void main(String[] args) {
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        RedBinaria red = new RedBinaria(ab);
        System.out.println("El mayor retardo posible es de: " + red.retardoEnvio(ab) + " segundos");

	}

}
