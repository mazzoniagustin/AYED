package TP2;
import TP2.BinaryTree;

public class isLeftTree {
	private BinaryTree<Integer> arbol;
	
	public isLeftTree(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree1(int num) {
		boolean ok = false;
		if (!arbol.isEmpty() && arbol != null) {
			 ok = isLeftTreeHelper(arbol,num);
		}
		return ok;
	}
	
	
	private boolean isLeftTreeHelper(BinaryTree<Integer> arbol, int num) {
		int hijoDer = -1;
		int hijoIzq = -1;
		
		BinaryTree<Integer> nodo = buscar(arbol,num);
		
		if (nodo.hasLeftChild()) {
			hijoIzq = contarHijos(nodo.getLeftChild());
		}
		
		if (nodo.hasRightChild()) {
			hijoDer = contarHijos(nodo.getRightChild());
		}
		
		return hijoIzq > hijoDer;
		
	}
	
	
	public int contarHijos(BinaryTree<Integer> nodo) {
		int cant = 0;
		if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild())) {
			cant++;
		}
		if (nodo.hasLeftChild()) {
			cant+= contarHijos(nodo.getLeftChild());
		}
		if (nodo.hasRightChild()) {
			cant+= contarHijos(nodo.getRightChild());
		}
		return cant;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int num) {
		if (arbol.getData() == num) {
			return arbol;
		}
		else {
			BinaryTree<Integer> res = new BinaryTree<Integer>();
			if (arbol.hasLeftChild()) {
				res = buscar(arbol.getLeftChild(),num);
			}
			if (arbol.hasRightChild() && res == null) {
				res = buscar(arbol.getRightChild(),num);
			}
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
