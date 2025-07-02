package Parciales;
import TP2.BinaryTree;
import TP2.Queue;
public class Parcial8 {
	private BinaryTree<Integer> ab;
	
	public Parcial8(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> minEnNivelAB(int n) {
		if (!ab.isEmpty() && (ab != null)) {
			BinaryTree<Integer> nodo = minEnNivelHelper(BinaryTree<Integer> ab, n);
		}
		else {
			return null;
		}
	}
	
	private BinaryTree<Integer> minEnNivelHelper(BinaryTree<Integer> ab, int nivel) {
		BinaryTree<Integer> minHoja = new BinaryTree<Integer>();
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		
		int niv = 0;
		int min = 9999;
		
		cola.enqueue(ab);
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			BinaryTree<Integer> aux = cola.dequeue();
			
			if (aux != null) {
				if ((niv == nivel) && (aux.getData() < min)) {
					min = aux.getData();
					minHoja = aux;
				}
				else {
					if (aux.hasLeftChild()) {
						cola.enqueue(aux.getLeftChild());
					}
					if (aux.hasRightChild()) {
						cola.enqueue(aux.getRightChild());
					}
				}
			}
			else {
				if (!cola.isEmpty()) {
					niv++;
					cola.enqueue(null);
				}
				}
			}	
		return minHoja;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
