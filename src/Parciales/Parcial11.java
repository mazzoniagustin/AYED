package Parciales;
import TP2.BinaryTree;
import java.util.*;
public class Parcial11 {
	private BinaryTree<Integer> ab;
	
	public Parcial11(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public List<Integer> resolver(BinaryTree<Integer> ab) {
		List<Integer> listaNumeros = new LinkedList<Integer>();
		if (!ab.isEmpty()) {
			resolverHelper(ab,listaNumeros);
		}
		return listaNumeros;
	}
	
	
	private static void resolverHelper(BinaryTree<Integer> ab, List<Integer> lista) {
		int izq = 0;
		int der = 0;
		
		if (ab.hasLeftChild()) {
			izq = contarNodos(ab.getLeftChild());
			resolverHelper(ab.getLeftChild(),lista);
		}
		
		if (ab.hasRightChild()) {
			der = contarNodos(ab.getRightChild());
			resolverHelper(ab.getRightChild(),lista);
		}
		
		if (izq == der) {
			lista.add(ab.getData());
		}
	}
	
	
	
	private static int contarNodos(BinaryTree<Integer> ab) {
		
		int cant = 0;
		
		if (ab.hasLeftChild()) {
			cant += contarNodos(ab.getLeftChild());
		}
		
		if (ab.hasRightChild()) {
			cant += contarNodos(ab.getRightChild());
		}
		return cant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
