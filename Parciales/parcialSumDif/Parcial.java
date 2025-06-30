package Parciales.parcialSumDif;
import TP2.BinaryTree;

public class Parcial {
	private BinaryTree<Integer> ab;
	
	public Parcial(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<sumAndDif> sumAndDif(BinaryTree<Integer> ab) {
		BinaryTree<sumAndDif> ab2 = new BinaryTree<sumAndDif>();
		if (!ab.isEmpty()) {
			sumAndDifHelper(ab, ab2, 0, 0);
		}
		return ab2;
	}
	
	private void sumAndDifHelper(BinaryTree<Integer> ab, BinaryTree<sumAndDif> ab2, int suma, int padre) {
		int valor = ab.getData();
		sumAndDif sad = new sumAndDif(valor+suma, valor-padre);
		ab2.setData(sad);
		
		if (ab.hasLeftChild()) {
			ab2.addLeftChild(new BinaryTree<sumAndDif>());
			sumAndDifHelper(ab.getLeftChild(),ab2.getLeftChild(),suma+valor,valor);
		}
		
		if (ab.hasRightChild()) {
			ab2.addRightChild(new BinaryTree<sumAndDif>());
			sumAndDifHelper(ab.getRightChild(),ab2.getRightChild(),suma+valor,valor);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
