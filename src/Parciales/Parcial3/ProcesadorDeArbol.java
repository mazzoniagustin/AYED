package Parciales.Parcial3;
import TP2.BinaryTree;
import java.util.*;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> ab;
	
	public ProcesadorDeArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int procesar() {
		List<BinaryTree<Integer>> res = new LinkedList<BinaryTree<Integer>>();
		if (!ab.isEmpty()) {
			return procesarHelper(ab,res);
		}
		else {
			return -1;
		}
	}
	
	private int procesarHelper(BinaryTree<Integer> ab , List<BinaryTree<Integer>> resultado) {
		int cant = 0;
		if (ab.hasLeftChild()) {
			cant = procesarHelper(ab.getLeftChild(), resultado);
		}
		if (ab.hasRightChild()) {
			cant = procesarHelper(ab.getRightChild(), resultado);
		}
		if (ab.getData() % 2 == 0) {
			if (ab.hasRightChild() && ab.hasLeftChild()) {
				resultado.add(ab);
				cant++;
			}
		}
		return cant;
	}

}
