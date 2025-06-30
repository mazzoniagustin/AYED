package Parciales;
import TP2.BinaryTree;

public class parcialMonodistante {
	
	
	public boolean resolver(int k) {
		
	}
	
	private boolean resolverHelper(BinaryTree<Integer> arbol , int k, int sumaActual) {
		sumaActual+= arbol.getData();
		
		if (arbol.isLeaf()) {
			if (sumaActual == k) {
				return true;
			}
			else {
				return false;
			}
		}
		boolean res = true;
		if (arbol.hasLeftChild()) {
			res = resolverHelper(arbol.getLeftChild(),k,sumaActual);
		}
		if (res && arbol.hasRightChild()) {
			res = resolverHelper(arbol.getRightChild(),k,sumaActual);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
