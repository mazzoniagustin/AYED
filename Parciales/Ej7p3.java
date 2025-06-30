package Parciales;
import TP2.BinaryTree;

public class Ej7p3 {
	private BinaryTree<Integer> arbol;
	
	public Ej7p3(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		boolean seCumple = false;
		if (!arbol.isEmpty()) {
			BinaryTree<Integer> nodo = buscar(arbol, num);
			if (nodo != null) {
				seCumple = isLeftTreeHelper(arbol);
			}
			
		}
		return seCumple;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int num) {
		if (arbol.getData() == num) {
			return arbol;
		}
		else {
			BinaryTree<Integer> aux;
			if (arbol.hasLeftChild()) {
				aux = buscar(arbol.getLeftChild(),num);
			}
			else {
				if ((arbol.hasRightChild()) && (aux == null)) {
					aux = buscar(arbol.getRightChild(),num);
				}
			}
			return aux;
		}
	}
	
	private int contarUnicoHijo(BinaryTree<Integer> arbol) {
		int cant = 0;
		if (arbol.hasLeftChild() && !arbol.hasRightChild()) {
			cant++;
		}
		if (arbol.hasLeftChild()) {
			cant += contarUnicoHijo(arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			cant += contarUnicoHijo(arbol.getRightChild());
		}
		return cant;
	}
	
	private boolean isLeftTreeHelper(BinaryTree<Integer> arbol) {
		int hijoIzq = 0;
		int hijoDer = 0;
		
		if (arbol.hasLeftChild()) {
			hijoIzq = contarUnicoHijo(arbol.getLeftChild());
		}
		
		if (arbol.hasRightChild()) {
			hijoDer = contarUnicoHijo(arbol.getRightChild());
		}
		
		return hijoIzq > hijoDer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
