package Parciales;
import TP2.BinaryTree;
import java.util.*;

public class caminoQueCumpla {
	
	public List<Integer> resolver (BinaryTree<Integer> ab , int num) {
		
	}
	
	private boolean resolverHelper(BinaryTree<Integer> ab, int num, int pares, List<Integer> camino) {
		camino.add(ab.getData());
		
		if (ab.getData() % 2 == 0) {
			pares++;
		}
		
		if (ab.isLeaf()) {
			if (cant < num) {
				camino.remove(camino.size()-1);
				return false;
			}
			else {
				return true;
			}
		}
		boolean encontrado = false;
		if (ab.hasLeftChild() && !encontrado) {
			encontrado = resolverHelper(ab.getLeftChild(),num,pares,camino);
		}
		if (ab.hasRightChild() && !encontrado) {
			encontrado = resolverHelper(ab.getLeftChild(),num,pares,camino);
		}
		
		if (!encontrado) {
			camino.remove(camino.size()-1);
		}
		return encontrado;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
