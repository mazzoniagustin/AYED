package TP2;

public class esPrefijo {
	
	
	public boolean esPrefijo1(BinaryTree<Integer>arbol1 , BinaryTree<Integer>arbol2) {
		if (!arbol1.isEmpty() && !arbol2.isEmpty()) {
			return esPrefijoHelper(arbol1,arbol2);
		}
		else {
			if (!arbol1.isEmpty() && arbol2.isEmpty() || arbol1.isEmpty() && !arbol2.isEmpty()) {
				return false;
			}
		}
		return false;
	}
	
	private boolean esPrefijoHelper(BinaryTree<Integer>arbol1 , BinaryTree<Integer>arbol2) {
		if (arbol1.getData() != arbol2.getData()) {
			return false;
		}
		
		boolean res = false;
		if (arbol1.hasLeftChild()) {
			if (arbol2.hasLeftChild()) {
				res = esPrefijoHelper(arbol1.getLeftChild() , arbol2.getLeftChild());
				}
			else {
				return false;
			}
			}
		if (arbol1.hasRightChild()) {e
			if (arbol2.hasRightChild()) {
				res = esPrefijoHelper(arbol1.getRightChild(), arbol2.getRightChild());
			}
			else {
				return false;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
